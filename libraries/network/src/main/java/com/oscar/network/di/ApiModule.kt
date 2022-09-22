package com.oscar.network.di

import android.content.Context
import com.oscar.network.BuildConfig
import com.oscar.network.util.NetworkHandler
import com.oscar.network.util.NetworkHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideINetworkAwareHandler(@ApplicationContext context: Context) =
        NetworkHandlerImpl(context) as NetworkHandler

    private fun getOkHttpClientBuilder(): OkHttpClient.Builder {

        // Timeout setup
        val okHttpClientBuilder = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        // Failure retry setup
        okHttpClientBuilder.retryOnConnectionFailure(true)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(logging)

        return okHttpClientBuilder
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = getOkHttpClientBuilder()

        // App specific configuration
        okHttpClientBuilder.addInterceptor { chain ->
            val timestamp = System.currentTimeMillis().toString()
            val privateKey = BuildConfig.PRIVATE_API_KEY
            val publicKey = BuildConfig.PUBLIC_API_KEY

            val url = chain.request()
                .url
                .newBuilder()
                .addQueryParameter("apikey", publicKey)
                .addQueryParameter("ts", timestamp)
                .addQueryParameter("hash", md5("$timestamp$privateKey$publicKey"))
                .build()

            val request = chain.request()
                .newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .url(url)
                .build()

            val response = chain.proceed(request)

            response
        }

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}