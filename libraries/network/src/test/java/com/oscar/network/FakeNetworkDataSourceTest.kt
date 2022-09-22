package com.oscar.network

import com.oscar.network.fake.FakeNetworkDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FakeNetworkDataSourceTest {

    private lateinit var subject: FakeNetworkDataSource

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        subject = FakeNetworkDataSource(
            ioDispatcher = testDispatcher,
            networkJson = Json { ignoreUnknownKeys = true }
        )
    }

    @Test
    fun testNumOfCharacters() = runTest(testDispatcher) {
        val numOfCharacters = subject.getCharacters(0).data.results.size
        assertEquals(4, numOfCharacters)
    }

    @Test
    fun testFirstCharacter() = runTest(testDispatcher) {
        val character = subject.getCharacters(0).data.results.firstOrNull()
        assertEquals("3-D Man", character?.name)
    }

}