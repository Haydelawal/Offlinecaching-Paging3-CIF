package com.example.offlinecaching_cif_paging3.paging.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.offlinecaching_cif_paging3.Constants.RESTAURANT_KEYS_TABLE

@Entity(tableName = RESTAURANT_KEYS_TABLE)
data class RestaurantRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)