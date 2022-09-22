package com.oscar.network.di

import com.oscar.network.api.MarvelCharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitServiceModule {

    @Provides
    fun provideMarvelCharacterService(retrofit: Retrofit): MarvelCharacterService {
        return retrofit.create(MarvelCharacterService::class.java)
    }
}