package com.oscar.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oscar.model.Character
import com.oscar.model.Pagination


@Entity(
    tableName = "character"
)

data class CharacterEntity(
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo(name = "description")
    val description: String = "",
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "image")
    val image: String = "",
    @ColumnInfo(name = "count")
    val count: Int = 0,
    @ColumnInfo(name = "limit")
    val limit: Int = 0,
    @ColumnInfo(name = "offset")
    val offset: Int = 0,
    @ColumnInfo(name = "total")
    val total: Int = 0
)

fun CharacterEntity.asDomainModel() = Character(
    id = id,
    name = name,
    description = description,
    image = image,
    pagination = Pagination(
        count = count,
        limit = limit,
        offset = offset,
        total = total
    )
)
