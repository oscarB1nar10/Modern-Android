object Compose {
    const val compose_compiler_version = "1.3.0"
    private const val compose_navigation_version = "2.4.2"
    private const val compose_animation_version = "1.2.1"
    private const val compose_foundation_version = "1.2.1"
    const val compose_material = "1.2.1"
    private const val compose_runtime = "1.2.1"
    const val compose_ui = "1.2.1"
    private const val compose_ui_tooling = "1.2.1"
    private const val compose_ui_tooling_preview = "1.2.1"
    private const val activity_version = "1.3.1"
    private const val coil_version = "2.2.1"

    const val ui = "androidx.compose.ui:ui:$compose_ui"
    const val material = "androidx.compose.material:material:$compose_material"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$compose_ui_tooling_preview"
    const val activity = "androidx.activity:activity-compose:$activity_version"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$compose_ui_tooling"
    const val navigation = "androidx.navigation:navigation-compose:$compose_navigation_version"
    const val coil = "io.coil-kt:coil-compose:$coil_version"
    const val animation = "androidx.compose.animation:animation:$compose_animation_version"
    const val foundation = "androidx.compose.foundation:foundation:$compose_foundation_version"
    const val runtime = "androidx.compose.runtime:runtime:$compose_runtime"

    private const val hiltHiltNavigationComposeVersion = "1.0.0"
    const val hiltNavigation =
        "androidx.hilt:hilt-navigation-compose:$hiltHiltNavigationComposeVersion"
}