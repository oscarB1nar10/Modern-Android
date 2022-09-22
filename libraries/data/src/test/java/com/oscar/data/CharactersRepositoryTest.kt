package com.oscar.data

import com.oscar.comon.result.successOr
import com.oscar.data.repository.CharactersRepository
import com.oscar.data.repository.CharactersRepositoryImpl
import com.oscar.database.dao.CharacterDao
import com.oscar.model.Character
import com.oscar.model.Pagination
import com.oscar.network.NetworkDataSource
import com.oscar.network.util.NetworkHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharactersRepositoryTest {

    private lateinit var marvelCharactersRepository: CharactersRepository
    private lateinit var characterDao: CharacterDao
    private lateinit var networkDataSource: NetworkDataSource

    @Before
    fun setUp() {
        characterDao = TestCharacterDao()
        networkDataSource = TestNetworkDataSource()

        marvelCharactersRepository = CharactersRepositoryImpl(
            networkHandler = object : NetworkHandler {},
            characterDao = characterDao,
            networkDataSource = networkDataSource
        )
    }

    @Test
    fun testGetCharacters() = runTest {
        val charactersResult =
            marvelCharactersRepository.getCharacters(Pagination())
        charactersResult.map {
            val characters = it.successOr(listOf())
            assertEquals(4, characters.size)
        }
    }

    @Test
    fun testGetCharacterById() = runTest {
        // Retrieve and insert characters first into local db
        marvelCharactersRepository.getCharacters(Pagination()).collect {}

        // Fetch character by id from local db
        val characterId = 1017100
        val charactersResult = marvelCharactersRepository.getCharacterById(characterId)
        val character = charactersResult.successOr(Character())
        assertEquals("A-Bomb (HAS)", character.name)
    }
}













