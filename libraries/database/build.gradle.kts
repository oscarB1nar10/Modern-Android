apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    // Room
    "implementation"(Room.roomRuntime)
    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "testImplementation"(Room.roomTesting)
}