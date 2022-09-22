package com.oscar.hero_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.comon.result.successOr
import com.oscar.constants.PAGINATION_DEFAULT_OFFSET
import com.oscar.data.repository.CharactersRepository
import com.oscar.hero_list.ui_state.CharactersScreenUiState
import com.oscar.model.Character
import com.oscar.model.Pagination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(CharactersScreenUiState())
    val uiState: StateFlow<CharactersScreenUiState> = _uiState.asStateFlow()

    init {
        onGetCharacters()
    }

    fun onGetCharacters(pagination: Pagination = Pagination()) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            charactersRepository.getCharacters(pagination).collect { result ->
                val characters = result.successOr(listOf())
                updateCharacters(characters)
            }
        }
    }

    fun onExecuteSearch() {
        val characterName = _uiState.value.characterName

        _uiState.update { it.copy(isLoading = true) }

        val filteredCharacters = _uiState.value.characters.filter { character ->
            character.name.lowercase().contains(characterName.lowercase())
        }

        _uiState.update {
            it.copy(
                filteredCharacters = filteredCharacters,
                isLoading = false
            )
        }
    }

    fun onLoadMoreCharacters(currentScrollPosition: Int) {
        val numOfCharactersDisplayed = _uiState.value.count
        val pageNumber = _uiState.value.pageNumber
        val totalNumOfCharacters = _uiState.value.total
        val newOffset = pageNumber * PAGINATION_DEFAULT_OFFSET

        // Prevent duplicate events due to recompose happening to quickly
        if (currentScrollPosition >= (numOfCharactersDisplayed - 1)) {
            // Fetch new characters if there are still available
            if (newOffset < totalNumOfCharacters) {
                onGetCharacters(Pagination(offset = newOffset))
            }
        }
    }

    fun updateCharacterName(characterName: String) {
        _uiState.update { it.copy(characterName = characterName) }
    }

    private fun updateCharacters(characters: List<Character>) {
        val totalOfCharacters = characters.firstOrNull()?.pagination?.total ?: 0
        val currentPageNumber = _uiState.value.pageNumber

        _uiState.update { charactersScreenUiState ->
            charactersScreenUiState.copy(
                characters = characters,
                filteredCharacters = characters,
                pageNumber = currentPageNumber + 1,
                total = totalOfCharacters,
                count = characters.size,
                isLoading = false
            )
        }
    }
}