package com.oscar.hero_detail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.request.ImageRequest
import coil.size.Size
import com.oscar.design_system.component.DetailImage
import com.oscar.design_system.component.Divider
import com.oscar.design_system.component.Header
import com.oscar.design_system.component.ModerAndroidSurface
import com.oscar.hero_detail.ui_state.CharacterDetailScreenUiState
import com.oscar.model.Character

private val TitleHeight = 128.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun CharacterDetailRoute(
    characterId: Int,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val characterDetailScreenUiState = viewModel.uiState.collectAsState()

    // Fetch only one time
    if (characterDetailScreenUiState.value.character.id != characterId) {
        viewModel.onGetCharacterById(characterId)
    }

    CharacterDetailScreen(characterDetailScreenUiState.value)
}

@Composable
fun CharacterDetailScreen(
    characterDetailScreenUiState: CharacterDetailScreenUiState
) {
    val character = characterDetailScreenUiState.character

    val model = ImageRequest.Builder(LocalContext.current)
        .data(character.image)
        .size(Size.ORIGINAL)
        .crossfade(true)
        .build()

    Box(
        Modifier.fillMaxSize()
    ) {
        val scroll = rememberScrollState(0)
        Header()
        Body(
            character = character,
            scroll = scroll
        )
        Title(
            character = character,
            scrollProvider = { scroll.value }
        )
        DetailImage(imageUrl = character.image) { scroll.value }
    }
}

@Composable
private fun Body(
    character: Character,
    scroll: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(GradientScroll))
            ModerAndroidSurface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(ImageOverlap))
                    Spacer(Modifier.height(TitleHeight))

                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = character.description,
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = HzPadding
                    )

                    Spacer(Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
private fun Title(character: Character, scrollProvider: () -> Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .offset {
                val scroll = scrollProvider()
                val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
                IntOffset(x = 0, y = offset.toInt())
            }
            .background(color = MaterialTheme.colors.background)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = character.name,
            style = MaterialTheme.typography.h1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = HzPadding
        )
        Spacer(Modifier.height(8.dp))
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterDetailScreen() {
    CharacterDetailScreen(
        CharacterDetailScreenUiState(
            Character(
                id = 1,
                name = "Batman",
                description = "Dark knight"
            )
        )
    )
}