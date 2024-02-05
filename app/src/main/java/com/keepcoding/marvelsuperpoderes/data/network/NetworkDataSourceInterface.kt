package com.keepcoding.marvelsuperpoderes.data.network

import com.keepcoding.marvelsuperpoderes.domain.CharacterRemote

interface NetworkDataSourceInterface {
    suspend fun getCharacters(): List<CharacterRemote>
}