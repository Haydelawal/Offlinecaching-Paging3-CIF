package com.example.offlinecaching_cif_paging3.paging.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.offlinecaching_cif_paging3.paging.db.model.RestaurantRemoteKey

@Dao
interface RestaurantRemoteKeysDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRemoteKeys(list: List<RestaurantRemoteKey>)

    @Query("SELECT * FROM restaurant_remote_keys_table WHERE id = :id")
    suspend fun getAllRemoteKeys(id: Int): RestaurantRemoteKey?

    @Query("DELETE FROM restaurant_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}