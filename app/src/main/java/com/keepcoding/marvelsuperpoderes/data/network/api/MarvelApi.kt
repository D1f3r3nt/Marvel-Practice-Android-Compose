package com.keepcoding.marvelsuperpoderes.data.network.api

import com.keepcoding.marvelsuperpoderes.data.network.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("orderBy") orderBy: String,
    ): CharactersResponse
}