package com.oscar.network.di

import com.oscar.network.NetworkDataSource
import com.oscar.network.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindsNetworkDataSource(
        networkDataSource: NetworkDataSourceImpl
    ): NetworkDataSource
}