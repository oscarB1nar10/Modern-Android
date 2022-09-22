package com.oscar.hero_list

import com.oscar.testing.TestCharactersRepository
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

    private val charactersRepository = TestCharactersRepository()
    private lateinit var charactersViewModel: CharactersViewModel

    @Before
    fun setup() {
        charactersViewModel = CharactersViewModel(
            charactersRepository
        )
    }

    @Test
    fun testGetCharacters() = runTest {
        charactersViewModel.onGetCharacters()
        val characters = charactersViewModel.uiState.value.characters
        assertEquals(2, characters.size)

        // Assert first character name
        assertEquals("3-D Man", characters.firstOrNull()?.name ?: "")
    }
}