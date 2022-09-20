package com.oscar.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacterDataContainer(
    @SerializedName("offset")
    val offset: Int = 0,
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("results")
    val results: List<NetworkCharacter> = listOf(),
)
