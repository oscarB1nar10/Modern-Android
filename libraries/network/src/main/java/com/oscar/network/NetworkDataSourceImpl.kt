package com.oscar.network

import com.oscar.network.api.MarvelCharacterApi
import com.oscar.network.model.NetworkCharacterDataWrapper
import javax.inject.Inject

class NetworkDataSourceImpl
@Inject
constructor(private val marvelCharacterApi: MarvelCharacterApi) : NetworkDataSource {

    override suspend fun getMarvelCharacters(): NetworkCharacterDataWrapper {
        return marvelCharacterApi.getCharacters(limit = 20, offset = 0)
    }

}
