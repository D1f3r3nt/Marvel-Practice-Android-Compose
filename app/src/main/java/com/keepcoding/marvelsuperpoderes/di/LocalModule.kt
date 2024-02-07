package com.keepcoding.marvelsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.keepcoding.marvelsuperpoderes.data.local.LocalDataSource
import com.keepcoding.marvelsuperpoderes.data.local.LocalDataSourceInterface
import com.keepcoding.marvelsuperpoderes.data.local.db.CharacterDao
import com.keepcoding.marvelsuperpoderes.data.local.db.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesLocalDataSource(localDataSource: LocalDataSource): LocalDataSourceInterface {
        return localDataSource
    }

    @Provides
    fun providesHeroDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            "character-database"
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun providesHeroDao(db: CharacterDatabase): CharacterDao {
        return db.characterDao()
    }
}