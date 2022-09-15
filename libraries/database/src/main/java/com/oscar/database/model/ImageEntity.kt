package com.oscar.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "image"
)

data class ImageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "character_id")
    val characterId: Int,
    @ColumnInfo(name = "path")
    val path: String,
    @ColumnInfo(name = "extension")
    val extension: String
)
