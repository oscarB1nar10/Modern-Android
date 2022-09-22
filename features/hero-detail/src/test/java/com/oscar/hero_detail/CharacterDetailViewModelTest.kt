package com.oscar.hero_detail

import com.oscar.testing.TestCharactersRepository
import com.oscar.testing.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterDetailViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val charactersRepository = TestCharactersRepository()
    private lateinit var charactersViewModel: CharacterDetailViewModel

    @Before
    fun setup() {
        charactersViewModel = CharacterDetailViewModel(
            charactersRepository
        )
    }

    @Test
    fun testGetCharacters() = runTest {
        charactersViewModel.onGetCharacterById(1011334)
        val character = charactersViewModel.uiState.value.character
        assertEquals("3-D Man", character.name)
    }
}