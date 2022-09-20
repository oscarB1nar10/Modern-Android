package com.oscar.data

import com.oscar.comon.result.successOr
import com.oscar.data.repository.MarvelCharactersRepository
import com.oscar.data.repository.MarvelCharactersRepositoryImpl
import com.oscar.database.dao.CharacterDao
import com.oscar.model.Character
import com.oscar.network.NetworkDataSource
import com.oscar.network.util.NetworkHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MarvelCharactersRepositoryTest {

    private lateinit var marvelCharactersRepository: MarvelCharactersRepository
    private lateinit var characterDao: CharacterDao
    private lateinit var networkDataSource: NetworkDataSource

    @Before
    fun setUp() {
        characterDao = TestCharacterDao()
        networkDataSource = TestNetworkDataSource()

        marvelCharactersRepository = MarvelCharactersRepositoryImpl(
            networkHandler = object : NetworkHandler {},
            characterDao = characterDao,
            networkDataSource = networkDataSource
        )
    }

    @Test
    fun testGetCharacters() = runTest {
        val charactersResult =
            marvelCharactersRepository.getCharacters(0 /*Start fetching from index 20*/)
        val characters = charactersResult.successOr(listOf())
        assertEquals(4, characters.size)
    }

    @Test
    fun testGetCharacterById() = runTest {
        // Retrieve and insert characters first into local db
        marvelCharactersRepository.getCharacters(0 /*Start fetching from index 20*/)

        // Fetch character by id from local db
        val characterId = 1017100
        val characterResult = marvelCharactersRepository.getCharacterById(characterId)
        val character = characterResult.successOr(Character())
        assertEquals("A-Bomb (HAS)", character.name)
    }
}













