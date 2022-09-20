package com.oscar.network.fake

import com.oscar.network.NetworkDataSource
import com.oscar.network.model.NetworkCharacterDataWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class FakeNetworkDataSource @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val networkJson: Json
) : NetworkDataSource {

    override suspend fun getMarvelCharacters(): NetworkCharacterDataWrapper =
        withContext(ioDispatcher) {
            networkJson.decodeFromString(FakeDataSource.marvelCharacters)
        }
}