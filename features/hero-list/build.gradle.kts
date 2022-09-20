apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    // modules
    "implementation"(project(Modules.data))
    "implementation"(project(Modules.comon))
    "implementation"(project(Modules.model))
    "implementation"(project(Modules.testing))
}