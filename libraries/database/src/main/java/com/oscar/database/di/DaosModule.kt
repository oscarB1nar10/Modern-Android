package com.oscar.database.di

import com.oscar.database.OpenBankDatabase
import com.oscar.database.dao.CharacterDao
import com.oscar.database.dao.CharacterDataContainerDao
import com.oscar.database.dao.CharacterDataWrapperDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun provideCharacterDataWrapperDao(
        database: OpenBankDatabase
    ): CharacterDataWrapperDao = database.characterDataWrapperDao()

    @Provides
    fun provideCharacterDataContainerDao(
        database: OpenBankDatabase
    ): CharacterDataContainerDao = database.characterDataContainerDao()

    @Provides
    fun provideCharacterDao(
        database: OpenBankDatabase
    ): CharacterDao = database.characterDao()
}