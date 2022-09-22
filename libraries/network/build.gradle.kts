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

    // OkHttp (For network request)
    "implementation"(platform(OkHttp.okhttpBom))
    "implementation"(OkHttp.okhttp3)
    "implementation"(OkHttp.loginInterceptor)

    // Serialization
    "implementation"(AndroidX.serialization)
}