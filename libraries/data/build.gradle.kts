apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    // modules
    "implementation"(project(Modules.database))
    "implementation"(project(Modules.network))
    "implementation"(project(Modules.comon))
    "implementation"(project(Modules.model))
}