package com.oscar.data.mappers

import com.oscar.model.Pagination
import com.oscar.database.model.CharacterEntity
import com.oscar.network.model.NetworkCharacter
import com.oscar.network.model.NetworkCharacterDataContainer


fun NetworkCharacterDataContainer.asCharacters(): List<CharacterEntity> {
    val pagination = Pagination(
        count = count,
        limit = limit,
        offset = offset,
        total = total
    )

    return this.results.map { networkCharacter ->
        networkCharacter.asEntity(pagination)
    }
}

fun NetworkCharacter.asEntity(pagination: Pagination) = CharacterEntity(
    description = description,
    name = name,
    image = thumbnail.path,
    count = pagination.count,
    limit = pagination.limit,
    offset = pagination.offset,
    total = pagination.total
)