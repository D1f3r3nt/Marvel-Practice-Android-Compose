package com.keepcoding.marvelsuperpoderes.data

import com.keepcoding.marvelsuperpoderes.domain.CharacterUI
import com.keepcoding.marvelsuperpoderes.domain.ComicUI

interface RepositoryInterface {
    suspend fun getCharacters(): List<CharacterUI>
    suspend fun getCharacter(id: String): CharacterUI
    suspend fun getComics(id: String): List<ComicUI>
}