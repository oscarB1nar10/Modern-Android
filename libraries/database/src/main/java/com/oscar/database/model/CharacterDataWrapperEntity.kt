package com.oscar.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oscar.database.heroes.Data


@Entity(
    tableName = "character_data_wrapper"
)

data class CharacterDataWrapperEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "attribution_html")
    val attributionHTML: String,
    @ColumnInfo(name = "data")
    val data: Data,
    @ColumnInfo(name = "etag")
    val etag: String
)