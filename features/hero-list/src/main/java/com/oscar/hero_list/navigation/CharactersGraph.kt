package com.oscar.hero_list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.oscar.hero_list.CharactersRoute
import com.oscar.navigation.OpenBankNavigationDestination

object CharactersDestination : OpenBankNavigationDestination {
    override val route = "characters_route"
    override val destination = "characters_destination"

}

fun NavGraphBuilder.charactersGraph(
    navigateToCharacterDetail: (String) -> Unit,
) {
    composable(route = CharactersDestination.route) {
        CharactersRoute(
            navigateToCharacterDetail
        )
    }
}