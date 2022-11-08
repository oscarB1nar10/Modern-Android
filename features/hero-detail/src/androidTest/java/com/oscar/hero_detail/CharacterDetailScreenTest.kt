package com.oscar.hero_detail

import ModernAndroidTheme
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.oscar.hero_detail.ui_state.CharacterDetailScreenUiState
import com.oscar.model.Character
import com.oscar.model.Pagination
import org.junit.Rule
import org.junit.Test

class CharacterDetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testCharacterIsDisplayed() {
        composeTestRule.setContent {
            ModernAndroidTheme {
                CharacterDetailScreen(
                    CharacterDetailScreenUiState(
                        character = character
                    )
                )
            }
        }

        composeTestRule.onNodeWithText("3-D Man")
            .assertIsDisplayed()
    }

    private val count = 20
    private val limit = 20
    private val offset = 0
    private val total = 1562

    private val character = Character(
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
    )

}