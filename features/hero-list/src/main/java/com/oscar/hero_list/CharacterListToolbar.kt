package com.oscar.hero_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oscar.constants.TEST_TAG_CHARACTER_SEARCH_BAR
import com.oscar.constants.TEST_TAG_FILTER_BTN


@Composable
fun CharacterListToolbar(
    characterName: String,
    onCharacterNameChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 12.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(8.dp)
                    .testTag(TEST_TAG_CHARACTER_SEARCH_BAR),
                value = characterName,
                onValueChange = {
                    onCharacterNameChanged(it)
                    onExecuteSearch()
                },
                label = { Text(text = "Search") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onExecuteSearch()
                    },
                ),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {}
            ) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .testTag(TEST_TAG_FILTER_BTN),
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Filter Icon"
                )
            }
        }
    }
}