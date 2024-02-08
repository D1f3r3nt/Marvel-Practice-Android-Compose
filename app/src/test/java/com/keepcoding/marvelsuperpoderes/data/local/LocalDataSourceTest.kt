package com.keepcoding.marvelsuperpoderes.data.local

import com.google.common.truth.Truth
import com.keepcoding.marvelsuperpoderes.utils.generateLocalCharacters
import com.keepcoding.marvelsuperpoderes.data.local.db.CharacterDao
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LocalDataSourceTest {

    private lateinit var dao: CharacterDao

    @Before
    fun setUp() {
        dao = mockk()
    }

    @Test
    fun `WHEN getCharacters THEN success list`() = runTest {
        // Given
        val localDataSource = LocalDataSource(dao)
        val expected = generateLocalCharacters(20)
        
        coEvery { localDataSource.getDataCharacters() } returns expected

        // When
        val actual = localDataSource.getDataCharacters()

        // Then
        Assert.assertTrue(actual.isNotEmpty())
        Truth.assertThat(actual).containsExactlyElementsIn(expected)
    }

    @Test
    fun `WHEN insertCharacter THEN success`() = runTest {
        // Given
        val localDataSource = LocalDataSource(dao)
        val character = generateLocalCharacters(1)[0]

        coEvery { localDataSource.insertCharacter(character) } returns Unit

        // When
        val actual = localDataSource.insertCharacter(character)

        // Then
        Assert.assertNotNull(actual)
    }

    @Test
    fun `WHEN updateCharacter THEN success`() = runTest {
        // Given
        val localDataSource = LocalDataSource(dao)
        val character = generateLocalCharacters(1)[0]

        coEvery { localDataSource.updateCharacter(character) } returns Unit

        // When
        val actual = localDataSource.updateCharacter(character)

        // Then
        Assert.assertNotNull(actual)
    }

    @Test
    fun `WHEN toggleFavoriteCharacter THEN success`() = runTest {
        // Given
        val localDataSource = LocalDataSource(dao)
        val id = 1L

        coEvery { localDataSource.toggleFavoriteCharacter(id) } returns Unit

        // When
        val actual = localDataSource.toggleFavoriteCharacter(id)

        // Then
        Assert.assertNotNull(actual)
    }

    @After
    fun tearDown() {

    }

}