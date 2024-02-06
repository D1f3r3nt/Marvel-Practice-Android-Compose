package com.keepcoding.marvelsuperpoderes.domain

import com.keepcoding.marvelsuperpoderes.data.network.response.Comics
import com.keepcoding.marvelsuperpoderes.data.network.response.Stories
import com.keepcoding.marvelsuperpoderes.data.network.response.Thumbnail
import com.keepcoding.marvelsuperpoderes.data.network.response.URL

data class CharacterUI(
    val id: Long,
    val name: String,
    val description: String,
    val photo: String,
    var favorite: Boolean,
)

data class CharacterRemote(
    val id: Long,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comics,
    val series: Comics,
    val stories: Stories,
    val events: Comics,
    val urls: List<URL>
)

fun CharacterRemote.toUI(): CharacterUI {
    return CharacterUI(this.id, this.name, this.description, "${thumbnail.path}.${thumbnail.extension}", false)
}

fun List<CharacterRemote>.toUI(): List<CharacterUI> {
    return this.map { it.toUI() }
}