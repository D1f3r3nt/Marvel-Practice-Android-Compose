package com.keepcoding.marvelsuperpoderes.data

import com.keepcoding.marvelsuperpoderes.data.local.LocalDataSourceInterface
import com.keepcoding.marvelsuperpoderes.data.network.NetworkDataSourceInterface
import com.keepcoding.marvelsuperpoderes.domain.CharacterUI
import com.keepcoding.marvelsuperpoderes.domain.ComicUI
import com.keepcoding.marvelsuperpoderes.domain.toUI
import javax.inject.Inject

class Repository @Inject constructor(
    private val networkDataSource: NetworkDataSourceInterface,
    private val localDataSource: LocalDataSourceInterface,
) : RepositoryInterface {

    override suspend fun getCharacters(): List<CharacterUI> {
        return networkDataSource.getCharacters().toUI()
    }

    override suspend fun getCharacter(id: String): CharacterUI {
        return networkDataSource.getCharacter(id).toUI()
    }

    override suspend fun getComics(id: String): List<ComicUI> {
        return networkDataSource.getComic(id).toUI()
    }

}