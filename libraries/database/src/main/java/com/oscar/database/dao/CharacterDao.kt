package com.oscar.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.oscar.database.model.CharacterAndImage

@Dao
interface CharacterDao {

    @Transaction
    @Query("SELECT * FROM character")
    fun getCharacterAndImage(): CharacterAndImage
}