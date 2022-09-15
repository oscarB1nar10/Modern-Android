package com.oscar.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oscar.database.dao.CharacterDao
import com.oscar.database.dao.CharacterDataContainerDao
import com.oscar.database.dao.CharacterDataWrapperDao
import com.oscar.database.model.CharacterDataContainerEntity
import com.oscar.database.model.CharacterDataWrapperEntity
import com.oscar.database.model.CharacterEntity
import com.oscar.database.model.ImageEntity

@Database(
    entities = [
        CharacterDataWrapperEntity::class,
        CharacterDataContainerEntity::class,
        CharacterEntity::class,
        ImageEntity::class
    ],
    version = 1,
    exportSchema = true
)

abstract class OpenBankDatabase : RoomDatabase() {
    abstract fun characterDataWrapperDao(): CharacterDataWrapperDao
    abstract fun characterDataContainerDao(): CharacterDataContainerDao
    abstract fun characterDao(): CharacterDao
}