package com.oscar.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerializedName("path")
    val path: String = "",
    @SerializedName("extension")
    val extension: String = "",
)