package com.oscar.database.model

import androidx.room.Embedded
import androidx.room.Relation


data class CharacterAndImage(
    @Embedded val character: CharacterEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val image: ImageEntity
)
