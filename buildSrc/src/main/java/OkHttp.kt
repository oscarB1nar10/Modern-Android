object OkHttp {
    private const val okhttpVersion = "4.9.3"

    // Define a BOM and its version
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:$okhttpVersion"

    // Define any required OkHttp artifacts without version
    const val okhttp3 = "com.squareup.okhttp3:okhttp"
    const val loginInterceptor = "com.squareup.okhttp3:logging-interceptor"
}