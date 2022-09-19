package com.oscar.network

import com.oscar.network.model.NetworkCharacterDataWrapper

interface NetworkDataSource {
    suspend fun getMarvelCharacters(): NetworkCharacterDataWrapper
}