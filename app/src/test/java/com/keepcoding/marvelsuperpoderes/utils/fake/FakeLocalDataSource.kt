package com.keepcoding.marvelsuperpoderes.utils.fake

import com.keepcoding.marvelsuperpoderes.data.local.LocalDataSourceInterface
import com.keepcoding.marvelsuperpoderes.domain.CharacterLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLocalDataSource : LocalDataSourceInterface {

    private var database = mutableListOf<CharacterLocal>()
    override fun getCachedCharacters(): Flow<List<CharacterLocal>> {
        return flow {
            emit(database)
        }
    }

    override suspend fun getDataCharacters(): List<CharacterLocal> {
        return database
    }

    override suspend fun insertCharacter(character: CharacterLocal) {
        database.add(character)
    }

    override suspend fun updateCharacter(character: CharacterLocal) {
        database.remove(character)
        database.add(character)
    }

    override suspend fun toggleFavoriteCharacter(id: Long) {
        database = database.map {
            if (it.id == id) {
                it.favorite = !it.favorite
            }
            it
        }.toMutableList()
    }


}