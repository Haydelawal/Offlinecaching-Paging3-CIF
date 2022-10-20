package com.example.offlinecaching_cif_paging3.paging.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.offlinecaching_cif_paging3.api.Api
import com.example.offlinecaching_cif_paging3.model.RestApiResponse
import com.example.offlinecaching_cif_paging3.paging.db.RestaurantDatabase
import com.example.offlinecaching_cif_paging3.paging.db.model.RestaurantRemoteKey

@ExperimentalPagingApi
class MyRemoteMediator(
    private val api: Api,
    private val restaurantDatabase: RestaurantDatabase
) : RemoteMediator<Int, RestApiResponse>()
{

    private val restaurantDao = restaurantDatabase.restaurantDao()
    private val restaurantRemoteKeysDao = restaurantDatabase.restaurantRemoteKeysDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RestApiResponse>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            val response = api.getResponse()
            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            restaurantDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    restaurantDao.deleteAllRestaurants()
                    restaurantRemoteKeysDao.deleteAllRemoteKeys()
                }
                val keys = response.map { restApiResponse ->
                    RestaurantRemoteKey(
                        id = restApiResponse.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                restaurantRemoteKeysDao.insertAllRemoteKeys(list =  keys)
                restaurantDao.insertRestaurants(list = response)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, RestApiResponse>
    ): RestaurantRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                restaurantRemoteKeysDao.getAllRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, RestApiResponse>
    ): RestaurantRemoteKey? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { apiResponse ->
                restaurantRemoteKeysDao.getAllRemoteKeys(id = apiResponse.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, RestApiResponse>
    ): RestaurantRemoteKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { apiResponse ->
                restaurantRemoteKeysDao.getAllRemoteKeys(id = apiResponse.id)
            }
    }
}