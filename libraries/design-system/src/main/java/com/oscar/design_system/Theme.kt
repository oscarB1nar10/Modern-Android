import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.oscar.design_system.DarkGreen20
import com.oscar.design_system.DarkGreenGray90
import com.oscar.design_system.Err
import com.oscar.design_system.OpenBankShapes
import com.oscar.design_system.OpenBankTypography
import com.oscar.design_system.PrimaryColor
import com.oscar.design_system.PrimaryVariant
import com.oscar.design_system.SecondaryColor
import com.oscar.design_system.SecondaryVariant

/**
 * Light default theme color scheme
 */
@VisibleForTesting
private val LightThemeColors = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryVariant,
    onPrimary = Color.White,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryVariant,
    onSecondary = Color.White,
    error = Err,
    background = Color.White,
    onBackground = Color.Black
)

/**
 * Dark default theme color scheme
 */
@VisibleForTesting
private val DarkThemeColors = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryVariant,
    onPrimary = Color.White,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryVariant,
    onSecondary = DarkGreen20,
    error = Err,
    background = Color.Black,
    onBackground = DarkGreenGray90
)

@Composable
fun OpenBankTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = OpenBankTypography,
        shapes = OpenBankShapes,
        content = content
    )
}

