package com.example.m8_eac2_ex2.network

import com.example.m8_eac2_ex2.dades.Character
import com.example.m8_eac2_ex2.dades.CharacterData
import com.example.m8_eac2_ex2.dades.Episode
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.Retrofit
import kotlin.getValue
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.GET

private val baseUrl =
    "https://rickandmortyapi.com/api/"

private val json = Json { ignoreUnknownKeys = true }

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(baseUrl)
    .build()



interface RickAndMortyApiService {

    @GET("character")
    suspend fun getCharacter(): Character

    @GET("episode/{id}")
    suspend fun getEpisode(): Episode

}


object RickAndMortyApi {
    val retrofitService : RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }
}