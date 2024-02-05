package com.keepcoding.marvelsuperpoderes.data

import com.keepcoding.marvelsuperpoderes.domain.CharacterUI

interface RepositoryInterface {
    suspend fun getCharacters(): List<CharacterUI>
}