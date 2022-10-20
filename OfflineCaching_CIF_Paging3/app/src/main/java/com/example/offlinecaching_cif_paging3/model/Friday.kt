package com.example.offlinecaching_cif_paging3.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Friday(

    @SerializedName("is_closed")
    val isClosedFri: Boolean,
    @SerializedName("opens_at")
    val opensAtFri: String
)