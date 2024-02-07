package com.keepcoding.marvelsuperpoderes.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
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

fun CharacterUI.toLocal(): CharacterLocal {
    return CharacterLocal(this.id, this.name, this.description, this.photo, this.favorite)
}

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

fun CharacterRemote.toUi(): CharacterUI {
    return CharacterUI(this.id, this.name, this.description, "${thumbnail.path}.${thumbnail.extension}", false)
}

fun List<CharacterRemote>.toUi(): List<CharacterUI> {
    return this.map { it.toUi() }
}

fun CharacterRemote.toLocal(): CharacterLocal {
    return CharacterLocal(this.id, this.name, this.description, "${thumbnail.path}.${thumbnail.extension}", false)
}

fun List<CharacterRemote>.toLocal(): List<CharacterLocal> {
    return this.map { it.toLocal() }
}

@Entity(tableName = "characters")
data class CharacterLocal(
    @PrimaryKey
    val id: Long,
    
    val name: String,
    
    val description: String,
    
    val photo: String,
    
    var favorite: Boolean,
)

fun CharacterLocal.toUI(): CharacterUI {
    return CharacterUI(this.id, this.name, this.description, this.photo, this.favorite)
}

fun List<CharacterLocal>.toUI(): List<CharacterUI> {
    return this.map { it.toUI() }
}