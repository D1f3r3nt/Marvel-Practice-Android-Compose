package com.keepcoding.marvelsuperpoderes.domain

import com.keepcoding.marvelsuperpoderes.data.network.response.Thumbnail

data class ComicUI (
    val id: Long,
    val digitalID: Long?,
    val title: String,
    val description: String? = null,
    val isbn: String,
    val pageCount: Long,
    val photo: String,
)

data class ComicRemote (
    val id: Long,
    val digitalID: Long?,
    val title: String,
    val description: String? = null,
    val isbn: String,
    val pageCount: Long,
    val thumbnail: Thumbnail,
)

fun ComicRemote.toUI(): ComicUI = ComicUI(
    this.id, 
    this.digitalID, 
    this.title, 
    this.description, 
    this.isbn, 
    this.pageCount, 
    "${this.thumbnail.path}.${this.thumbnail.extension}"
)

fun List<ComicRemote>.toUI(): List<ComicUI> = this.map { it.toUI() }