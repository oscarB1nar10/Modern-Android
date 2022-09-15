package com.oscar.network

import com.oscar.network.api.MarvelCharacterApi
import com.oscar.network.model.CharacterDataWrapper
import javax.inject.Inject

class NetworkDataSourceImpl
@Inject
constructor(private val marvelCharacterApi: MarvelCharacterApi) : NetworkDataSource {

    override suspend fun getMarvelCharacters(): CharacterDataWrapper {
        return marvelCharacterApi.getTopics(limit = 20, offset = 0)
    }

}
