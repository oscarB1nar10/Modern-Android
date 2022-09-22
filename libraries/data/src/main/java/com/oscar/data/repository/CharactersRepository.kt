package com.oscar.data.repository

import com.oscar.comon.result.Result
import com.oscar.model.Character
import com.oscar.model.Pagination
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(pagination: Pagination): Flow<Result<List<Character>>>

    suspend fun getCharacterById(characterId: Int): Result<Character>
}