package com.oscar.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("thumbnail")
    val image: Image,
)
