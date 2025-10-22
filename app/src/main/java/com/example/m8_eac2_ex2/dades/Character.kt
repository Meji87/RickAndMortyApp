package com.example.m8_eac2_ex2.dades

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val results: List<CharacterData>
)
@Serializable
data class CharacterData(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val episode: List<String>
)
