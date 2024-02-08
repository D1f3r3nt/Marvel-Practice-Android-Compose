package com.keepcoding.marvelsuperpoderes.data

import com.keepcoding.marvelsuperpoderes.utils.fake.FakeLocalDataSource
import com.keepcoding.marvelsuperpoderes.data.network.NetworkDataSource
import com.keepcoding.marvelsuperpoderes.utils.generateRemoteCharacters
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RepostioryTest {

    private lateinit var localDataSource: FakeLocalDataSource
    private lateinit var remoteDataSource: NetworkDataSource

    @Before
    fun setUp() {
        localDataSource = FakeLocalDataSource()
        remoteDataSource = NetworkDataSource(mockk())
    }

    @Test
    fun `WHEN local getCharacters empty THEN get from remote and save in local`() = runTest {
        val repository = Repository(remoteDataSource, localDataSource)

        val expectedRemote = generateRemoteCharacters(1)

        coEvery { remoteDataSource.getCharacters() } returns expectedRemote

        repository.getDataCharacters()
        val actual = repository.getCachedCharacters().toList()

        coVerify(exactly = 1) { remoteDataSource.getCharacters() }
        assertEquals(1, actual.size)
    }

    @Test
    fun `WHEN getHeroDetail THEN get from local`() = runTest {
        val repository = Repository(remoteDataSource, localDataSource)
        val id = "1"
        
        val expectedRemote = generateRemoteCharacters(1)[0]
        coEvery { remoteDataSource.getCharacter(id) } returns expectedRemote

        val actual = repository.getCharacter(id)

        assertEquals(id.toLong(), actual.id)
    }
}