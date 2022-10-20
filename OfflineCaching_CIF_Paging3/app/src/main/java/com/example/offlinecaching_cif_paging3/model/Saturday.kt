package com.example.offlinecaching_cif_paging3.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Saturday(
    @SerializedName("closes_at")
    val closesAtSat: String,
    @SerializedName("is_closed")
    val isClosedSat: Boolean,
    @SerializedName("opens_at")
    val opensAtSat: String
)