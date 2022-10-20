package com.example.offlinecaching_cif_paging3.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Wednesday(
    @SerializedName("closes_at")
    val closesAtWed: String,
    @SerializedName("is_closed")
    val isClosedWed: Boolean,
    @SerializedName("opens_at")
    val opensAtWed: String
)