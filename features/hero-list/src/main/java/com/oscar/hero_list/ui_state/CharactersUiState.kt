package com.oscar.hero_list.ui_state

import com.oscar.model.Character

data class CharactersScreenUiState(
    val charactersUiState: CharactersUiState = CharactersUiState(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)

data class CharactersUiState(
    val characters: List<Character> = listOf(),
    val offset: Int = 0
)

fun CharactersScreenUiState.getOffset(): Int {
    return this.charactersUiState.offset
}

fun CharactersScreenUiState.getCharacters(): List<Character> {
    return this.charactersUiState.characters
}