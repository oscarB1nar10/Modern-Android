package com.oscar.hero_detail

import OpenBankTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.oscar.hero_detail.ui_state.CharacterDetailScreenUiState
import com.oscar.model.Character
import com.oscar.model.Pagination
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class CharacterDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testCharacterIsDisplayed() {
        composeTestRule.setContent {
            OpenBankTheme {
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