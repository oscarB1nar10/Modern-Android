package com.oscar.design_system.component

import ModernAndroidTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.oscar.constants.TEST_TAG_LOADING_WHEEL


@Composable
fun LoadingWheel(isLoading: Boolean) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .testTag(TEST_TAG_LOADING_WHEEL),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProgressBarComponentComposable() {
    ModernAndroidTheme {
        LoadingWheel(isLoading = true)
    }
}