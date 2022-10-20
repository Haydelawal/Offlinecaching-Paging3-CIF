package com.example.offlinecaching_cif_paging3.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Monday(
    @SerializedName("closes_at")
    val closesAtMon: String,
    @SerializedName("is_closed")
    val isClosedMon: Boolean,
    @SerializedName("opens_at")
    val opensAtMon: String
)