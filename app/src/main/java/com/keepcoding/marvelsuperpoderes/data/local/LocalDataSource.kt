package com.keepcoding.marvelsuperpoderes.data.local

import com.keepcoding.marvelsuperpoderes.data.local.db.CharacterDao
import com.keepcoding.marvelsuperpoderes.domain.CharacterLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: CharacterDao,
): LocalDataSourceInterface {
    
    override fun getCachedCharacters(): Flow<List<CharacterLocal>> {
        return dao.getCachedCharacters()
    }

    override suspend fun getDataCharacters(): List<CharacterLocal> {
        return dao.getDataCharacters()
    }

    override suspend fun insertCharacter(character: CharacterLocal) {
        return dao.insertCharacter(character)
    }

    override suspend fun updateCharacter(character: CharacterLocal) {
        return dao.updateCharacter(character.id, character.name, character.description, character.photo)
    }

    override suspend fun toggleFavoriteCharacter(id: Long) {
        return dao.toggleFavoriteCharacter(id)
    }
}