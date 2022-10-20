package com.example.offlinecaching_cif_paging3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.offlinecaching_cif_paging3.api.Api
import com.example.offlinecaching_cif_paging3.paging.MyPagingSource
import com.example.offlinecaching_cif_paging3.repo.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @OptIn(ExperimentalPagingApi::class)
@Inject constructor(
//    private val api: Api
//) : ViewModel() {
//
//    val listData = Pager(
//        PagingConfig(
//            pageSize = 1,
//            enablePlaceholders = false
//        )
//    ) {
//        MyPagingSource(api)
//    }
//        .flow
//        .cachedIn(viewModelScope)
//}
    repository: MyRepository
): ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    val getAllRestaurants = repository.getAllRestaurants()
}