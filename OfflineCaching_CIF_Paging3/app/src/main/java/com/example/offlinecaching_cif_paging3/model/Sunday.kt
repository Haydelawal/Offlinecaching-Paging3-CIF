package com.example.offlinecaching_cif_paging3.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Sunday(
    @SerializedName("closes_at")
    val closesAtSun: String,
    @SerializedName("is_closed")
    val isClosedSun: Boolean,
    @SerializedName("opens_at")
    val opensAtSun: String
)