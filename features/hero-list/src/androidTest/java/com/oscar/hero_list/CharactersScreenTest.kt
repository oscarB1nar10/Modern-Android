package com.oscar.hero_list

import OpenBankTheme
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import com.oscar.constants.TEST_TAG_CHARACTERS
import com.oscar.constants.TEST_TAG_CHARACTER_SEARCH_BAR
import com.oscar.hero_list.ui_state.CharactersScreenUiState
import com.oscar.model.Character
import com.oscar.model.Pagination
import org.junit.Rule
import org.junit.Test

class CharactersScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()


    @Test
    fun testCharactersAreDisplayed() {
        composeTestRule.setContent {
            OpenBankTheme {
                CharactersScreen(
                    charactersUiState = CharactersScreenUiState(
                        characters = characters,
                        filteredCharacters = characters
                    ),
                    onLoadMoreCharacters = {},
                    onCharacterNameChanged = {},
                    onExecuteSearch = {},
                    onSelectCharacter = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(TEST_TAG_CHARACTERS)
            .onChildren()
            .assertCountEquals(3)
    }

    @Test
    fun testSearchToolbarIsDisplayed() {
        composeTestRule.setContent {
            OpenBankTheme {
                CharactersScreen(
                    charactersUiState = CharactersScreenUiState(
                        characters = characters,
                        filteredCharacters = characters
                    ),
                    onLoadMoreCharacters = {},
                    onCharacterNameChanged = {},
                    onExecuteSearch = {},
                    onSelectCharacter = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(TEST_TAG_CHARACTER_SEARCH_BAR)
            .assertIsDisplayed()
    }

    @Test
    fun testFilterCharacters() {
        composeTestRule.setContent {
            OpenBankTheme {
                CharactersScreen(
                    charactersUiState = CharactersScreenUiState(
                        characters = characters,
                        filteredCharacters = characters.filter { it.name.contains("A") }
                    ),
                    onLoadMoreCharacters = {},
                    onCharacterNameChanged = {},
                    onExecuteSearch = {},
                    onSelectCharacter = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(TEST_TAG_CHARACTERS)
            .onChildren()
            .assertCountEquals(2)
    }


    private val count = 20
    private val limit = 20
    private val offset = 0
    private val total = 1562

    private val characters = mutableListOf(
        Character(
            id = 1011334,
            name = "3-D Man",
            description = "",
            image = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
            pagination = Pagination(
                count = count,
                limit = limit,
                offset = offset,
                total = total
            )
        ),
        Character(
            id = 1017100,
            name = "A-Bomb (HAS)",
            description = "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
            image = "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
            pagination = Pagination(
                count = count,
                limit = limit,
                offset = offset,
                total = total
            )
        ),
        Character(
            id = 1010699,
            name = "Aaron Stack",
            description = "",
            image = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
            pagination = Pagination(
                count = count,
                limit = limit,
                offset = offset,
                total = total
            )
        )
    )
}