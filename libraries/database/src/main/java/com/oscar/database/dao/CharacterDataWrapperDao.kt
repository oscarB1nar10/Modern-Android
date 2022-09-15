package com.oscar.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.oscar.database.model.CharacterDataWrapperAndDataContainer

@Dao
interface CharacterDataWrapperDao {

    @Transaction
    @Query("SELECT * FROM character_data_wrapper")
    fun getCharacterWrapperAndDataContainer(): CharacterDataWrapperAndDataContainer
}