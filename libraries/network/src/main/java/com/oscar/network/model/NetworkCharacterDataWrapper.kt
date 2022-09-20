package com.oscar.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacterDataWrapper(
    @SerializedName("code")
    val code: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("data")
    val data: NetworkCharacterDataContainer,
    @SerializedName("etag")
    val etag: String
)
