package com.oscar.data.repository

import com.oscar.comon.result.Result
import com.oscar.model.Character

interface MarvelCharactersRepository {
    suspend fun getCharacters(listOffset: Int): Result<List<Character>>

    suspend fun getCharacterById(characterId: Int): Result<Character>
}