object AndroidX {
    private const val serializationVersion = "1.4.0"
    private const val coreKtxVersion = "1.7.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.4.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val constraintLayoutVersion = "2.1.3"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

    const val navigationVersion = "2.4.2"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"

    const val iconsExtended =
        "androidx.compose.material:material-icons-extended:${Compose.compose_material}"
    const val serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"
}

object AndroidXTest {

    private const val testCoreVersion = "1.4.0"
    private const val extJunitVersion = "1.1.3"
    private const val espressoCoreVersion = "3.4.0"
    const val extJunit = "androidx.test.ext:junit:$extJunitVersion"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
    const val testCore = "androidx.test:core:$testCoreVersion"
    const val testRules = "androidx.test:rules:$testCoreVersion"
    const val testRunner = "androidx.test:runner:$testCoreVersion"

    // Test rules and transitive dependencies:
    const val testJunit = "androidx.compose.ui:ui-test-junit4:${Compose.compose_ui}"

    // Needed for createComposeRule, but not createAndroidComposeRule:
    const val testManifest = "androidx.compose.ui:ui-test-manifest:${Compose.compose_ui}"

}