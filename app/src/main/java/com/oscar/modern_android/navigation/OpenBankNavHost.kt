package com.oscar.modern_android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.oscar.hero_detail.navigation.CharacterDetailDestination
import com.oscar.hero_detail.navigation.characterDetailGraph
import com.oscar.hero_list.navigation.CharactersDestination
import com.oscar.hero_list.navigation.charactersGraph
import com.oscar.navigation.OpenBankNavigationDestination

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun ModernAndroidNavHost(
    navController: NavHostController,
    onNavigateToDestination: (OpenBankNavigationDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = CharactersDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        charactersGraph(
            navigateToCharacterDetail = {
                onNavigateToDestination(
                    CharacterDetailDestination, CharacterDetailDestination.createNavigationRoute(it)
                )
            }
        )

        characterDetailGraph(
            onBackClick
        )
    }
}
