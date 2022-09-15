package com.oscar.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterDataContainerAndCharacter(
    @Embedded val characterDataContainer: CharacterDataContainerEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_container_id",
    )
    val characters: List<CharacterEntity>
)
