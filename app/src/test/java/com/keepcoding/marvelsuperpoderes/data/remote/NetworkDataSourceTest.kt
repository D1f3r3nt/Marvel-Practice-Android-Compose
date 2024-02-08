package com.keepcoding.marvelsuperpoderes.data.remote

import com.keepcoding.marvelsuperpoderes.utils.MockWebDispatcher
import com.keepcoding.marvelsuperpoderes.data.network.NetworkDataSource
import com.keepcoding.marvelsuperpoderes.data.network.api.MarvelApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkDataSourceTest {
    
    private lateinit var api: MarvelApi
    
    @Before
    fun setUp() {
        val mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MockWebDispatcher()
        mockWebServer.start()
        
        val loggerInterceptor = HttpLoggingInterceptor().apply { 
            level = HttpLoggingInterceptor.Level.BODY
        }
        
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggerInterceptor)
            .build()

        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        
        api = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MarvelApi::class.java)
    }
    
    @Test
    fun `WHEN getCharacters THEN succes list`() = runTest {
        // GIVEN
        val remoteDataSource = NetworkDataSource(api)
        
        // WHEN
        val characterList = remoteDataSource.getCharacters()
        
        // THEN
        Assert.assertTrue(characterList.isNotEmpty())
    }

    @Test
    fun `WHEN getComic THEN succes list`() = runTest {
        // GIVEN
        val remoteDataSource = NetworkDataSource(api)

        // WHEN
        val comicsList = remoteDataSource.getComic("1")

        // THEN
        Assert.assertTrue(comicsList.isNotEmpty())
    }
    
    @After
    fun tearDown() {
        
    }
}