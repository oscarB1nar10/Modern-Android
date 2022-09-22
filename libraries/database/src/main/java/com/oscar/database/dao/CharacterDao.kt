package com.oscar.database.dao

import androidx.room.*
import com.oscar.database.model.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character WHERE id = :characterId")
    suspend fun getCharacterById(characterId: Int): CharacterEntity

    @Query("SELECT * FROM character")
    fun getCharacters(): Flow<List<CharacterEntity>>

    /**
     * Inserts [characters] into the db if they don't exist, and ignores those that do
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterEntity>): List<Long>
}