package com.example.offlinecaching_cif_paging3.paging.db.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.offlinecaching_cif_paging3.model.RestApiResponse

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(list: List<RestApiResponse>)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertArticleSingle(article: Article)

    @Query("SELECT * FROM restaurant_table ")
    fun getAllRestaurants(): PagingSource<Int, RestApiResponse>

    @Query("DELETE FROM restaurant_table")
    suspend fun deleteAllRestaurants()
}