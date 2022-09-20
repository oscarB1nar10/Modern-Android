apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    // modules
    "implementation"(project(Modules.data))
    "implementation"(project(Modules.model))
    "implementation"(project(Modules.comon))

    // Room
    "implementation"(Room.roomRuntime)
    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "testImplementation"(Room.roomTesting)

    // Test tools required out of tests environment
    "implementation"(AndroidXTest.coroutineTest)
    "implementation"(Junit.junit4)
}