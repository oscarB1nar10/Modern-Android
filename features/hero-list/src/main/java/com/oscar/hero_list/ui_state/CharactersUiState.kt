package com.oscar.hero_list.ui_state

import com.oscar.model.Character

data class CharactersScreenUiState(
    val characters: List<Character> = listOf(),
    val filteredCharacters: List<Character> = listOf(),
    val characterName: String = "",
    val pageNumber: Int = 0 , // Default page to load
    val offset: Int = 0,
    val count: Int = 0,
    val total: Int = 0,
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)