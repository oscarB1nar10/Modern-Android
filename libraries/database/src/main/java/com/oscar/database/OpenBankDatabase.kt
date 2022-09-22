package com.oscar.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oscar.database.dao.CharacterDao
import com.oscar.database.model.CharacterEntity

@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1,
    exportSchema = true
)

abstract class OpenBankDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}