package com.oscar.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.oscar.database.model.CharacterDataContainerAndCharacter

@Dao
interface CharacterDataContainerDao {

    @Transaction
    @Query("SELECT * FROM character_data_container")
    fun getCharacterDataContainerAndCharacter(): List<CharacterDataContainerAndCharacter>
}