package com.oscar.hero_detail.navigation

import android.net.Uri
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.oscar.hero_detail.CharacterDetailRoute
import com.oscar.navigation.OpenBankNavigationDestination

object CharacterDetailDestination : OpenBankNavigationDestination {
    const val characterIdArg = "characterId"
    override val route = "character_detail_route/{$characterIdArg}"
    override val destination = "character_detail_destination"

    /**
     * Creates destination route for an characterId
     */
    fun createNavigationRoute(characterIdArg: String): String {
        return "character_detail_route/$characterIdArg"
    }

    /**
     * Returns the characterIdArg from a [NavBackStackEntry]
     */
    fun fromNavArgs(entry: NavBackStackEntry): String {
        val encodedId = entry.arguments?.getString(characterIdArg) ?: ""
        return Uri.decode(encodedId)
    }

}

fun NavGraphBuilder.characterDetailGraph(
    onBackClick: () -> Unit
) {
    composable(
        route = CharacterDetailDestination.route,
        arguments = listOf(
            navArgument(CharacterDetailDestination.characterIdArg) {
                type = NavType.StringType
            }
        )
    ) {
        CharacterDetailRoute(
            characterId = CharacterDetailDestination.fromNavArgs(it).toInt()
        )
    }
}