package com.keepcoding.marvelsuperpoderes.data

import com.keepcoding.marvelsuperpoderes.domain.CharacterUI
import com.keepcoding.marvelsuperpoderes.domain.ComicUI
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    fun getCachedCharacters(): Flow<List<CharacterUI>>
    suspend fun getDataCharacters()
    suspend fun getCharacter(id: String): CharacterUI
    suspend fun getComics(id: String): List<ComicUI>
    suspend fun insertCharacter(character: CharacterUI)
    suspend fun updateCharacter(character: CharacterUI)
    suspend fun toggleFavoriteCharacter(id: Long)
}