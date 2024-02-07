package com.keepcoding.marvelsuperpoderes.data.local

import com.keepcoding.marvelsuperpoderes.domain.CharacterLocal
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceInterface {
    fun getCachedCharacters(): Flow<List<CharacterLocal>>
    suspend fun getDataCharacters(): List<CharacterLocal>
    suspend fun insertCharacter(character: CharacterLocal)
    suspend fun updateCharacter(character: CharacterLocal)
    suspend fun toggleFavoriteCharacter(id: Long)
}