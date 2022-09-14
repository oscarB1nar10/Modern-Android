object Build {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.hiltVersion}"
    const val navigationSafeArgGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${AndroidX.navigationVersion}"
    const val kotlinToolsGradlePlugin = "com.android.tools.build:gradle:${Kotlin.toolsVersion}"
}