package com.keepcoding.marvelsuperpoderes.data.network

import com.keepcoding.marvelsuperpoderes.domain.CharacterRemote
import com.keepcoding.marvelsuperpoderes.domain.ComicRemote

interface NetworkDataSourceInterface {
    suspend fun getCharacters(): List<CharacterRemote>
    suspend fun getCharacter(id: String): CharacterRemote
    suspend fun getComic(id: String): List<ComicRemote>
}