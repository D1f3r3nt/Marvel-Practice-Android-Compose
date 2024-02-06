package com.keepcoding.marvelsuperpoderes.data.network.api

import com.keepcoding.marvelsuperpoderes.data.network.response.CharactersResponse
import com.keepcoding.marvelsuperpoderes.data.network.response.ComicResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("orderBy") orderBy: String,
    ): CharactersResponse

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") id: String,
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
    ): CharactersResponse

    @GET("/v1/public/characters/{id}/comics")
    suspend fun getComic(
        @Path("id") id: String,
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
    ): ComicResponse
}