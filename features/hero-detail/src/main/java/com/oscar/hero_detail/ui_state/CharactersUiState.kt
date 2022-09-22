package com.oscar.hero_detail.ui_state

import com.oscar.model.Character

data class CharacterDetailScreenUiState(
    val character: Character = Character(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)