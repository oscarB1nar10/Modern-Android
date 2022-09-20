package com.oscar.hero_list

import com.oscar.hero_list.ui_state.getCharacters
import com.oscar.testing.TestMarvelCharactersRepository
import com.oscar.testing.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharactersViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val charactersRepository = TestMarvelCharactersRepository()
    private lateinit var charactersViewModel: CharactersViewModel

    @Before
    fun setup() {
        charactersViewModel = CharactersViewModel(
            charactersRepository
        )
    }

    @Test
    fun testGetCharacters() = runTest {
        charactersViewModel.getCharacters()
        val characters = charactersViewModel.uiState.value.getCharacters()
        assertEquals(2, characters.size)

        // Assert first character name
        assertEquals("3-D Man", characters.firstOrNull()?.name ?: "")
    }
}