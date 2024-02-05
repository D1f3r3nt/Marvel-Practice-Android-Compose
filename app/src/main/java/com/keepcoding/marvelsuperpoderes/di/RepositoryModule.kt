package com.keepcoding.marvelsuperpoderes.di

import com.keepcoding.marvelsuperpoderes.data.Repository
import com.keepcoding.marvelsuperpoderes.data.RepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesRepository(repository: Repository): RepositoryInterface {
        return repository
    }
}