package com.keepcoding.marvelsuperpoderes.data.network.response

import com.keepcoding.marvelsuperpoderes.domain.ComicRemote

data class ComicResponse (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: DataComic
)

data class DataComic (
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<ComicRemote>
)