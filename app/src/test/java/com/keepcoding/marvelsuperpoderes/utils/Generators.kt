package com.keepcoding.marvelsuperpoderes.utils

import com.keepcoding.marvelsuperpoderes.data.network.response.Comics
import com.keepcoding.marvelsuperpoderes.data.network.response.Stories
import com.keepcoding.marvelsuperpoderes.data.network.response.Thumbnail
import com.keepcoding.marvelsuperpoderes.domain.CharacterLocal
import com.keepcoding.marvelsuperpoderes.domain.CharacterRemote

fun generateLocalCharacters(size: Int) = (1..size).map { CharacterLocal( it.toLong() , "name$it", "description$it", "photo$it", false) }

fun generateRemoteCharacters(size: Int) = (1..size).map { 
    CharacterRemote(
        it.toLong(),
        "name$it",
        "description$it",
        "modified$it",
        Thumbnail("", ""),
        "resourceURI$it",
        Comics(1L, "collectionURI$it", emptyList(), 1L),
        Comics(1L, "collectionURI$it", emptyList(), 1L),
        Stories(1L, "collectionURI$it", emptyList(), 1L),
        Comics(1L, "collectionURI$it", emptyList(), 1L),
        emptyList()
    )
}