package com.oscar.network

import com.oscar.constants.PAGINATION_CHARACTERS_LIMIT
import com.oscar.network.api.MarvelCharacterService
import com.oscar.network.model.NetworkCharacterDataWrapper
import javax.inject.Inject

class NetworkDataSourceImpl
@Inject
constructor(private val marvelCharacterService: MarvelCharacterService) : NetworkDataSource {

    override suspend fun getCharacters(offset: Int): NetworkCharacterDataWrapper {
        return marvelCharacterService.getCharacters(
            limit = PAGINATION_CHARACTERS_LIMIT,
            offset = offset
        )
    }

}
