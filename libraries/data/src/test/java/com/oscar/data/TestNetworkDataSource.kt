package com.oscar.data

import com.oscar.network.NetworkDataSource
import com.oscar.network.fake.FakeDataSource
import com.oscar.network.model.NetworkCharacterDataWrapper
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class TestNetworkDataSource : NetworkDataSource {

    private val networkJson = Json { ignoreUnknownKeys = true }

    private val networkCharacterDataWrapper =
        networkJson.decodeFromString<NetworkCharacterDataWrapper>(FakeDataSource.marvelCharacters)

    override suspend fun getCharacters(offset: Int): NetworkCharacterDataWrapper {
        return networkCharacterDataWrapper
    }
}