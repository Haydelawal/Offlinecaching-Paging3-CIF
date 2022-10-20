package com.example.offlinecaching_cif_paging3.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.offlinecaching_cif_paging3.Constants.RESTAURANT_TABLE
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = RESTAURANT_TABLE)
data class RestApiResponse(
    val address: String,
    val description: String,
    @Embedded
    val hours: Hours,
    @PrimaryKey
    val id: Int,
    val logo: String,
    val name: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    val review: String,
    val type: String,
    val uid: String
)