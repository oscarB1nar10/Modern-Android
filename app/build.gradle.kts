plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")

        // Specify the directory where to put the Room schema
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }

    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField("String", "BASE_API_URL", "\"https://gateway.marvel.com:443\"")
            buildConfigField("String", "PUBLIC_API_KEY", "\"c303d37dd6254c9f12f02dcbd5102165\"")
            buildConfigField("String", "PRIVATE_API_KEY", "\"26121b5a8849ac897ace8d33a66a6f731ff7a93a\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            signingConfig = signingConfigs.getByName("debug")
        }

        register("debugTesting") {
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField("String", "BASE_API_URL", "\"http://localhost:8080\"")
            buildConfigField("String", "PUBLIC_API_KEY", "\"abcde\"")
            buildConfigField("String", "PRIVATE_API_KEY", "\"abcde\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            signingConfig = signingConfigs.getByName("debug")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.compose_compiler_version
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

}

dependencies {
    // Import modules
    implementation(project(Modules.design_system))
    implementation(project(Modules.navigation))
    implementation(project(Modules.hero_list))

    // Import libraries
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)

    // Jetpack compose (UI)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.toolingPreview)
    implementation(Compose.activity)
    implementation(Compose.navigation)
    implementation(Compose.hiltNavigation)
    implementation(Compose.animation)
    implementation(Compose.foundation)
    implementation(Compose.runtime)
    implementation(Compose.coil)
    // In order to include all material icons
    implementation(AndroidX.iconsExtended)
    debugImplementation(Compose.uiTooling)

    // Hilt (Dependency injection)
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    // Unit Test
    testImplementation(Junit.junit4)
    testImplementation(AndroidXTest.extJunit)
    testImplementation(HiltTest.hiltAndroidTesting)
    testImplementation(AndroidXTest.testCore)
    testImplementation(AndroidXTest.coroutineTest)
    testImplementation(AndroidXTest.testRules)
    testImplementation(AndroidXTest.testRunner)

    // Espresso test
    testImplementation(AndroidXTest.espressoCore)

    // Compose tests
    androidTestImplementation(AndroidXTest.testJunit)
    debugImplementation(AndroidXTest.testManifest)

    // Gson (Mapper for network request)
    implementation(Gson.gson)

    // Timber (Logs)
    implementation(Timber.timber)

}