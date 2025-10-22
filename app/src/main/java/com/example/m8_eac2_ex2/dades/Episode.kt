package com.example.m8_eac2_ex2.dades

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val id: Int,
    val name: String,
    @SerialName("air_date")
    val airDate : String,
    val episode: String,
)
