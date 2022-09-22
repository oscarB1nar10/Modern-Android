package com.oscar.hero_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.comon.result.successOr
import com.oscar.data.repository.CharactersRepository
import com.oscar.hero_detail.ui_state.CharacterDetailScreenUiState
import com.oscar.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(CharacterDetailScreenUiState())
    val uiState: StateFlow<CharacterDetailScreenUiState> = _uiState.asStateFlow()

    fun onGetCharacterById(characterId: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val characterResult = charactersRepository.getCharacterById(characterId)
            val character = characterResult.successOr(Character())
            updateCharacter(character)
        }
    }

    private fun updateCharacter(character: Character) {
        _uiState.update {
            it.copy(
                character = character,
                isLoading = false
            )
        }
    }

}