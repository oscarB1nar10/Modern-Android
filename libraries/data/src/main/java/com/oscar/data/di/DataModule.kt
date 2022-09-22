package com.oscar.data.di

import com.oscar.data.repository.CharactersRepository
import com.oscar.data.repository.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMarvelCharactersRepository(
        marvelCharactersRepository: CharactersRepositoryImpl
    ): CharactersRepository
}