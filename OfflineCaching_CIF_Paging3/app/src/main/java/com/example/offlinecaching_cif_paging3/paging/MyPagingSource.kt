package com.example.offlinecaching_cif_paging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.offlinecaching_cif_paging3.api.Api
import com.example.offlinecaching_cif_paging3.model.RestApiResponse
import retrofit2.HttpException
import java.io.IOException

class MyPagingSource
    (private val api: Api) : PagingSource<Int, RestApiResponse>() {

    override fun getRefreshKey(state: PagingState<Int, RestApiResponse>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RestApiResponse> {

        val position = params.key ?: 1


        return try {

            val response = api.getResponse()


            val photos = response

            LoadResult.Page(
                data = photos,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1

            )


        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}
