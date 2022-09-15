package com.oscar.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterDataWrapperAndDataContainer(
    @Embedded val characterDataWrapper: CharacterDataWrapperEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_data_wrapper_id"
    )
    val characterDataContainer: CharacterDataContainerEntity
)
