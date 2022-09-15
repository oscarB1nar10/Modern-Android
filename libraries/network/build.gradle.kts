apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    // Retrofit (For network request)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.retrofitConverter)
    "implementation"(Retrofit.retrofitScalarConverter)

    // Serialization
    "implementation"(AndroidX.serialization)
}