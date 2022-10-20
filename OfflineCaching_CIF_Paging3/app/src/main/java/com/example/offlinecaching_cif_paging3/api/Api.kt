package com.example.offlinecaching_cif_paging3.api

import com.example.offlinecaching_cif_paging3.Constants.ENDPOINT
import com.example.offlinecaching_cif_paging3.model.RestApiResponse
import retrofit2.http.GET

interface Api {

    @GET(ENDPOINT)
    suspend fun getResponse(): List<RestApiResponse>
}