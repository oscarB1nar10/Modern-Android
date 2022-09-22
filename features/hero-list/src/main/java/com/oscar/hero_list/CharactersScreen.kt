package com.oscar.hero_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscar.constants.TEST_TAG_CHARACTERS
import com.oscar.design_system.component.LoadingWheel
import com.oscar.hero_list.ui_state.CharactersScreenUiState
import com.oscar.model.Character
import com.oscar.model.Pagination

@Composable
fun CharactersRoute(
    navigateToCharacterDetail: (String) -> Unit,
    viewModel: CharactersViewModel = hiltViewModel(),
) {
    val charactersScreenUiState = viewModel.uiState.collectAsState()
    CharactersScreen(
        charactersUiState = charactersScreenUiState.value,
        onLoadMoreCharacters = viewModel::onLoadMoreCharacters,
        onCharacterNameChanged = viewModel::updateCharacterName,
        onExecuteSearch = viewModel::onExecuteSearch,
        onSelectCharacter = navigateToCharacterDetail
    )
}

@Composable
fun CharactersScreen(
    charactersUiState: CharactersScreenUiState,
    onLoadMoreCharacters: (Int) -> Unit,
    onCharacterNameChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    onSelectCharacter: (String) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column {
            CharacterListToolbar(
                characterName = charactersUiState.characterName,
                onCharacterNameChanged = onCharacterNameChanged,
                onExecuteSearch = onExecuteSearch
            )

            val listState = rememberLazyListState()
            val penultimateScrollPosition by remember {
                derivedStateOf {
                    listState.layoutInfo.totalItemsCount.minus(1)
                }
            }

            val isScrollToEnd by remember {
                derivedStateOf {
                    listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == penultimateScrollPosition
                }
            }

            LazyColumn(
                modifier = Modifier
                    .testTag(TEST_TAG_CHARACTERS),
                state = listState,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    items = charactersUiState.filteredCharacters,
                    key = { character ->
                        character.id
                    }
                ) { character ->
                    HeroListItem(
                        character = character,
                        onSelectCharacter = onSelectCharacter
                    )
                }
            }

            if (isScrollToEnd && !charactersUiState.isLoading) {
                onLoadMoreCharacters(penultimateScrollPosition)
            }
        }
    }

    LoadingWheel(charactersUiState.isLoading)
}

@Preview(showBackground = true)
@Composable
fun PreviewCharactersScreen() {
    CharactersScreen(
        charactersUiState = CharactersScreenUiState(
            characters = listOf(
                Character(
                    id = 1011334,
                    name = "3-D Man",
                    description = "",
                    image = "",
                    pagination = Pagination()
                )
            )
        ),
        onLoadMoreCharacters = {},
        onCharacterNameChanged = {},
        onExecuteSearch = {},
        onSelectCharacter = {}
    )
}