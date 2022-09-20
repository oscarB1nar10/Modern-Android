apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    // Modules
    "implementation"(project(Modules.constants))

    // Retrofit (For network request)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.retrofitConverter)
    "implementation"(Retrofit.retrofitScalarConverter)
}