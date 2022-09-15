package com.oscar.network.api

import com.oscar.network.model.CharacterDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Retrofit API declaration for OpenBank Network API
 */
interface MarvelCharacterApi {

    @GET(value = "/v1/public/characters")
    suspend fun getTopics(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): CharacterDataWrapper
}