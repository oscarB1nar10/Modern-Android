package com.oscar.data.repository

import com.oscar.comon.result.ErrorHandling
import com.oscar.comon.result.Result
import com.oscar.data.mappers.asCharacters
import com.oscar.database.dao.CharacterDao
import com.oscar.database.model.asDomainModel
import com.oscar.model.Character
import com.oscar.network.NetworkDataSource
import com.oscar.network.util.NetworkHandler
import javax.inject.Inject

class MarvelCharactersRepositoryImpl
@Inject
constructor(
    private val networkHandler: NetworkHandler,
    private val characterDao: CharacterDao,
    private val networkDataSource: NetworkDataSource
) : MarvelCharactersRepository {

    override suspend fun getCharacters(listOffset: Int): Result<List<Character>> {
        return try {
            if (networkHandler.isOnline()) {
                // Fetch data from network
                val charactersContainer = networkDataSource.getMarvelCharacters().data
                // Save in local db
                characterDao.insertCharacters(charactersContainer.asCharacters())
                // Return data from local db
                syncData()
            } else {
                // Return data from local db
                syncData()
            }
        } catch (e: Exception) {
            val errorModel = ErrorHandling.handleError(e)
            return Result.Error(errorModel)
        }
    }

    override suspend fun getCharacterById(characterId: Int): Result<Character> {
        return try {
            // Fetch from local db only
            val characterEntity = characterDao.getCharacterById(characterId)
            Result.Success(characterEntity.asDomainModel())
        } catch (e: Exception) {
            val errorModel = ErrorHandling.handleError(e)
            Result.Error(errorModel)
        }
    }

    private fun syncData(): Result<List<Character>> {
        return Result.Success(characterDao.getCharacters().map { characterEntity ->
            characterEntity.asDomainModel()
        })
    }
}