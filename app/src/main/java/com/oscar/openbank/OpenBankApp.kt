package com.oscar.openbank

import OpenBankTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.oscar.navigation.util.goBack
import com.oscar.navigation.util.navigateTo
import com.oscar.openbank.navigation.OpenBankNavHost

@Composable
fun OpenBankApp() {
    OpenBankTheme {
        val navController = rememberNavController()

        Scaffold(
            contentColor = MaterialTheme.colors.onBackground,
        ) { padding ->

            OpenBankNavHost(
                navController = navController,
                onBackClick = navController::goBack,
                onNavigateToDestination = navController::navigateTo,
                modifier = Modifier
                    .padding(padding)
            )
        }
    }
}