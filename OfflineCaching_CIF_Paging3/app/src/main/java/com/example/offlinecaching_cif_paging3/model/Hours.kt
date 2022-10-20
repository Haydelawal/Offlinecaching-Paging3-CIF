package com.example.offlinecaching_cif_paging3.model

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class Hours(
    @Embedded
    val friday: Friday,
    @Embedded
    val monday: Monday,
    @Embedded
    val saturday: Saturday,
    @Embedded
    val sunday: Sunday,
    @Embedded
    val thursday: Thursday,
    @Embedded
    val tuesday: Tuesday,
    @Embedded
    val wednesday: Wednesday
)