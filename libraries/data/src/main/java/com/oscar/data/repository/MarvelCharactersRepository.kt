package com.oscar.data.repository

import com.oscar.comon.result.Result
import com.oscar.model.Character
import com.oscar.network.model.NetworkCharacter

interface MarvelCharactersRepository {
    suspend fun getCharacters(listOffset: Int): Result<List<Character>>
}