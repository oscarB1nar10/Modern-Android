package com.oscar.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.oscar.database.model.CharacterEntity

@Dao
interface CharacterDao {

    @Transaction
    @Query("SELECT * FROM character WHERE id = :characterId")
    fun getCharacterById(characterId: Int): CharacterEntity

    @Query("SELECT * FROM character")
    fun getCharacters(): List<CharacterEntity>

    /**
     * Inserts [characters] into the db if they don't exist, and ignores those that do
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCharacters(characters: List<CharacterEntity>): List<Long>
}