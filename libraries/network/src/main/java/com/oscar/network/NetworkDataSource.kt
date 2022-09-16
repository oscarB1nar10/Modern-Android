package com.oscar.network

import com.oscar.network.model.CharacterDataWrapper

interface NetworkDataSource {
    suspend fun getMarvelCharacters(): CharacterDataWrapper
}