package com.keepcoding.marvelsuperpoderes.data

import com.keepcoding.marvelsuperpoderes.data.local.LocalDataSourceInterface
import com.keepcoding.marvelsuperpoderes.data.network.NetworkDataSourceInterface
import com.keepcoding.marvelsuperpoderes.domain.CharacterLocal
import com.keepcoding.marvelsuperpoderes.domain.CharacterRemote
import com.keepcoding.marvelsuperpoderes.domain.CharacterUI
import com.keepcoding.marvelsuperpoderes.domain.ComicUI
import com.keepcoding.marvelsuperpoderes.domain.toLocal
import com.keepcoding.marvelsuperpoderes.domain.toUI
import com.keepcoding.marvelsuperpoderes.domain.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Repository @Inject constructor(
    private val networkDataSource: NetworkDataSourceInterface,
    private val localDataSource: LocalDataSourceInterface,
) : RepositoryInterface {

    override fun getCachedCharacters(): Flow<List<CharacterUI>> {
        return localDataSource.getCachedCharacters().map { it.map { characterLocal -> characterLocal.toUI() } }
    }

    override suspend fun getDataCharacters() {
        val remoteCharacters = networkDataSource.getCharacters()
        var oldBddCharacters = localDataSource.getDataCharacters()

        remoteCharacters.forEach { characterRemote ->
            val localInstance: CharacterLocal? = oldBddCharacters.find { it.id == characterRemote.id }

            // No existe
            if (localInstance == null) {
                localDataSource.insertCharacter(characterRemote.toLocal())

                // Si existe    
            } else {
                // Si hay cambios
                if (!localIsEqualToRemote(localInstance, characterRemote)) {
                    localDataSource.updateCharacter(characterRemote.toLocal())
                }
            }
        }
    }

    override suspend fun getCharacter(id: String): CharacterUI {
        return networkDataSource.getCharacter(id).toUi()
    }

    override suspend fun getComics(id: String): List<ComicUI> {
        return networkDataSource.getComic(id).toUI()
    }

    override suspend fun insertCharacter(character: CharacterUI) {
        localDataSource.insertCharacter(character.toLocal())
    }

    override suspend fun updateCharacter(character: CharacterUI) {
        localDataSource.updateCharacter(character.toLocal())
    }

    override suspend fun toggleFavoriteCharacter(id: Long) {
        localDataSource.toggleFavoriteCharacter(id)
    }

    private fun localIsEqualToRemote(characterLocal: CharacterLocal, characterRemote: CharacterRemote): Boolean {
        return (
                characterLocal.name == characterRemote.name &&
                        characterLocal.description == characterRemote.description &&
                        characterLocal.photo == "${characterRemote.thumbnail.path}.${characterRemote.thumbnail.extension}"
                )
    }

}