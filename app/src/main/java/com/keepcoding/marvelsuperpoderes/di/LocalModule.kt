package com.keepcoding.marvelsuperpoderes.di

import com.keepcoding.marvelsuperpoderes.data.local.LocalDataSource
import com.keepcoding.marvelsuperpoderes.data.local.LocalDataSourceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesLocalDataSource(localDataSource: LocalDataSource): LocalDataSourceInterface {
        return localDataSource
    }
}