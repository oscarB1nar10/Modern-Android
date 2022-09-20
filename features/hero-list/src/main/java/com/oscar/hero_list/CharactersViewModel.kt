package com.oscar.hero_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.comon.result.successOr
import com.oscar.data.repository.MarvelCharactersRepository
import com.oscar.hero_list.ui_state.CharactersScreenUiState
import com.oscar.hero_list.ui_state.CharactersUiState
import com.oscar.hero_list.ui_state.getOffset
import com.oscar.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: MarvelCharactersRepository
) : ViewModel() {

    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(CharactersScreenUiState())
    val uiState: StateFlow<CharactersScreenUiState> = _uiState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val charactersResult = charactersRepository.getCharacters(
                _uiState.value.charactersUiState.offset
            )

            val characters = charactersResult.successOr(listOf())
            updateUiState(characters)
        }
    }

    private fun updateUiState(characters: List<Character>) {
        val incomingOffset = characters.firstOrNull()?.pagination?.limit ?: 0
        val currentOffset = _uiState.value.getOffset()

        _uiState.update { charactersScreenUiState ->
            charactersScreenUiState.copy(
                charactersUiState = CharactersUiState(
                    characters = characters,
                    offset = currentOffset + incomingOffset
                ),
                isLoading = false
            )
        }
    }
}