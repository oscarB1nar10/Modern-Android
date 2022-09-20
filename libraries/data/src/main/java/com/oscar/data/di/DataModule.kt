package com.oscar.data.di

import com.oscar.data.repository.MarvelCharactersRepository
import com.oscar.data.repository.MarvelCharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMarvelCharactersRepository(
        marvelCharactersRepository: MarvelCharactersRepositoryImpl
    ): MarvelCharactersRepository
}