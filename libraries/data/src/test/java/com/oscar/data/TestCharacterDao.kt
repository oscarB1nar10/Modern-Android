package com.oscar.data

import com.oscar.database.dao.CharacterDao
import com.oscar.database.model.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestCharacterDao : CharacterDao {

    private var characterEntityList = mutableListOf<CharacterEntity>()

    override suspend fun getCharacterById(characterId: Int): CharacterEntity {
        val characterEntity = characterEntityList.firstOrNull { characterEntity ->
            characterEntity.characterId == characterId
        }

        return characterEntity ?: CharacterEntity()
    }

    override fun getCharacters(): Flow<List<CharacterEntity>> = flow {
        emit(characterEntityList)
    }

    override suspend fun insertCharacters(characters: List<CharacterEntity>): List<Long> {
        characterEntityList.addAll(characters)
        // Assume no conflicts on insert
        return characters.map { it.characterId.toLong() }
    }

}