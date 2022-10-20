package com.example.offlinecaching_cif_paging3.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Tuesday(
    @SerializedName("closes_at")
    val closesAtTues: String,
    @SerializedName("is_closed")
    val isClosedTues: Boolean,
    @SerializedName("opens_at")
    val opensAtTues: String
)