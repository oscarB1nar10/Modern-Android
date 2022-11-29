package com.oscar.hero_detail

import ModernAndroidTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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
            ModernAndroidTheme {
                CharacterDetailScreen(
                    CharacterDetailScreenUiState(
                        character = character
                    )
                )
            }
        }

        composeTestRule.onRoot().printToLog("currentLabelExists")

        composeTestRule.onNodeWithText("3-D Man")
            .assertExists()
    }

    private val count = 20
    private val limit = 20
    private val offset = 0
    private val total = 1562

    private val character = Character(
        id = 1011334,
        name = "3-D Man",
        description = "description",
        image = "",
        pagination = Pagination(
            count = count,
            limit = limit,
            offset = offset,
            total = total
        )
    )
}