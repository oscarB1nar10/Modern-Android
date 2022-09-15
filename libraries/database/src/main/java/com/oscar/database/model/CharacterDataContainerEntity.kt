package com.oscar.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_data_container"
)

data class CharacterDataContainerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "character_data_wrapper_id")
    val characterDataWrapperId: Long,
    @ColumnInfo(name = "count")
    val count: Int,
    @ColumnInfo(name = "limit")
    val limit: Int,
    @ColumnInfo(name = "offset")
    val offset: Int,
    @ColumnInfo(name = "total")
    val total: Int
)