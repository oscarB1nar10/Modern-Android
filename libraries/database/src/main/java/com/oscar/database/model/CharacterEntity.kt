package com.oscar.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "character"
)

data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "character_container_id")
    val characterContainerId: Long,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "name")
    val name: String
)
