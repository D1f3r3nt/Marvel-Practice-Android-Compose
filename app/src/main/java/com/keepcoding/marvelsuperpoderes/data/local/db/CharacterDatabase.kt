package com.keepcoding.marvelsuperpoderes.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepcoding.marvelsuperpoderes.domain.CharacterLocal

@Database(entities = [CharacterLocal::class], version = 1)
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}