object Compose {
    private const val compose_bom_version = "2022.10.00"
    const val compose_compiler_version = "1.3.0"
    private const val coil_version = "2.2.1"

    const val compose_bom = "androidx.compose:compose-bom:$compose_bom_version"
    const val ui = "androidx.compose.ui:ui"
    const val material = "androidx.compose.material:material"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val activity = "androidx.activity:activity-compose"
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val navigation = "androidx.navigation:navigation-compose"
    const val coil = "io.coil-kt:coil-compose:$coil_version"
    const val animation = "androidx.compose.animation:animation"
    const val foundation = "androidx.compose.foundation:foundation"
    const val runtime = "androidx.compose.runtime:runtime"

    private const val hiltHiltNavigationComposeVersion = "1.0.0"
    const val hiltNavigation =
        "androidx.hilt:hilt-navigation-compose:$hiltHiltNavigationComposeVersion"
}