package com.example.offlinecaching_cif_paging3.paging.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.offlinecaching_cif_paging3.model.RestApiResponse
import com.example.offlinecaching_cif_paging3.paging.db.daos.RestaurantDao
import com.example.offlinecaching_cif_paging3.paging.db.daos.RestaurantRemoteKeysDao
import com.example.offlinecaching_cif_paging3.paging.db.model.RestaurantRemoteKey

@Database(entities = [RestApiResponse::class, RestaurantRemoteKey::class], version = 1)
//@TypeConverters(RoomTypeConverter::class)

abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
    abstract fun restaurantRemoteKeysDao(): RestaurantRemoteKeysDao

}