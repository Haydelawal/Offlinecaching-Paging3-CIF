package com.example.offlinecaching_cif_paging3.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.offlinecaching_cif_paging3.Constants.ITEMS_PER_PAGE
import com.example.offlinecaching_cif_paging3.api.Api
import com.example.offlinecaching_cif_paging3.model.RestApiResponse
import com.example.offlinecaching_cif_paging3.paging.db.RestaurantDatabase
import com.example.offlinecaching_cif_paging3.paging.remote_mediator.MyRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class MyRepository @Inject constructor(
    private val api: Api,
    private val restaurantDatabase: RestaurantDatabase
) {

    fun getAllRestaurants(): Flow<PagingData<RestApiResponse>> {
        val pagingSourceFactory = { restaurantDatabase.restaurantDao().getAllRestaurants() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = MyRemoteMediator(
                api = api,
                restaurantDatabase = restaurantDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}