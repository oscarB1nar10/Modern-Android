package com.oscar.hero_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.oscar.hero_detail.ui_state.CharacterDetailScreenUiState
import com.oscar.model.Character

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
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        item {
            Column {

                val model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .size(Size.ORIGINAL)
                    .crossfade(true)
                    .build()

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 200.dp)
                        .background(Color.LightGray),
                    painter = rememberAsyncImagePainter(model),
                    contentDescription = "//TODO()",
                    contentScale = ContentScale.FillWidth,
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(end = 8.dp),
                            text = character.name,
                            style = MaterialTheme.typography.h1,
                        )

                        Image(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                                .align(Alignment.CenterVertically),
                            painter = rememberAsyncImagePainter(model),
                            contentDescription = "//TODO()",
                            contentScale = ContentScale.Crop,
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(bottom = 4.dp),
                        text = character.description,
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterDetailScreen(){
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