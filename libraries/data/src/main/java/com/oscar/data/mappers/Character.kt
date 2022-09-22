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

    val entities = this.results.map { networkCharacter ->
        networkCharacter.asEntity(pagination)
    }

    return entities
}

fun NetworkCharacter.asEntity(pagination: Pagination) = CharacterEntity(
    characterId = id,
    description = description,
    name = name,
    image = "${replaceHttpByHttps(thumbnail.path)}.${thumbnail.extension}",
    count = pagination.count,
    limit = pagination.limit,
    offset = pagination.offset,
    total = pagination.total
)

fun replaceHttpByHttps(originalPath: String): String {
    return originalPath.replace("http", "https")
}