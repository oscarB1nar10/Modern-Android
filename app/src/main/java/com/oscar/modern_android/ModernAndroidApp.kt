package com.oscar.modern_android

import ModernAndroidTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.oscar.navigation.util.goBack
import com.oscar.navigation.util.navigateTo
import com.oscar.modern_android.navigation.ModernAndroidNavHost

@Composable
fun OpenBankApp() {
    ModernAndroidTheme {
        val navController = rememberNavController()

        Scaffold(
            contentColor = MaterialTheme.colors.onBackground,
        ) { padding ->

            ModernAndroidNavHost(
                navController = navController,
                onBackClick = navController::goBack,
                onNavigateToDestination = navController::navigateTo,
                modifier = Modifier
                    .padding(padding)
            )
        }
    }
}