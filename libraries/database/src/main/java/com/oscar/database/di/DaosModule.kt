package com.oscar.database.di

import com.oscar.database.OpenBankDatabase
import com.oscar.database.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun provideCharacterDao(
        database: OpenBankDatabase
    ): CharacterDao = database.characterDao()
}