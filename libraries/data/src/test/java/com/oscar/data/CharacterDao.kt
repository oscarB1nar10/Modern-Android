package com.oscar.data

import com.oscar.database.dao.CharacterDao
import com.oscar.database.model.CharacterEntity

class TestCharacterDao : CharacterDao {

    private var characterEntityList = mutableListOf<CharacterEntity>()

    override fun getCharacterById(characterId: Int): CharacterEntity {
        val characterEntity = characterEntityList.firstOrNull { characterEntity ->
            characterEntity.id == characterId
        }

        return characterEntity ?: CharacterEntity()
    }

    override fun getCharacters(): List<CharacterEntity> {
        return characterEntityList
    }

    override fun insertCharacters(characters: List<CharacterEntity>): List<Long> {
        characterEntityList.addAll(characters)
        // Assume no conflicts on insert
        return characters.map { it.id.toLong() }
    }
}