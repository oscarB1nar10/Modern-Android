package com.oscar.network.api

import com.oscar.network.model.NetworkCharacterDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Retrofit API declaration for OpenBank Network API
 */
interface MarvelCharacterService {

    @GET(value = "/v1/public/characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): NetworkCharacterDataWrapper
}