package com.example.offlinecaching_cif_paging3.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Thursday(
    @SerializedName("closes_at")
    val closesAtThurs: String,
    @SerializedName("is_closed")
    val isClosedThurs: Boolean,
    @SerializedName("opens_at")
    val opensAtThurs: String
)