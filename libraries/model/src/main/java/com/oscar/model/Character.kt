package com.oscar.model


data class Character(
    val id: Int = -1,
    val name: String = "",
    val description: String = "",
    val image: String = "",
    val pagination: Pagination
)
