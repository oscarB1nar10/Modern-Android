apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    // modules
    "implementation"(project(Modules.database))
    "implementation"(project(Modules.network))
    "implementation"(project(Modules.comon))
    "implementation"(project(Modules.model))
    "implementation"(project(Modules.constants))

    // Room
    "implementation"(Room.roomRuntime)
    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "testImplementation"(Room.roomTesting)

    // Serialization
    "implementation"(AndroidX.serialization)
}