package com.keepcoding.marvelsuperpoderes.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keepcoding.marvelsuperpoderes.domain.CharacterLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters")
    fun getCachedCharacters(): Flow<List<CharacterLocal>>

    @Query("SELECT * FROM characters")
    fun getDataCharacters(): List<CharacterLocal>

    @Insert
    fun insertCharacter(character: CharacterLocal)

    @Query("UPDATE characters SET name = :name, description = :description, photo = :photo WHERE id = :id")
    fun updateCharacter(id: Long, name: String, description: String, photo: String)

    @Query("UPDATE characters SET favorite = NOT favorite WHERE id = :id")
    fun toggleFavoriteCharacter(id: Long)
}