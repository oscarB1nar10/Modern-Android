package com.oscar.data.repository

import com.oscar.comon.result.ErrorHandling
import com.oscar.comon.result.Result
import com.oscar.data.mappers.asCharacters
import com.oscar.database.dao.CharacterDao
import com.oscar.database.model.asDomainModel
import com.oscar.model.Character
import com.oscar.model.Pagination
import com.oscar.network.NetworkDataSource
import com.oscar.network.util.NetworkHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersRepositoryImpl
@Inject
constructor(
    private val networkHandler: NetworkHandler,
    private val characterDao: CharacterDao,
    private val networkDataSource: NetworkDataSource
) : CharactersRepository {

    override fun getCharacters(pagination: Pagination): Flow<Result<List<Character>>> = flow {
        try {
            if (networkHandler.isOnline()) {
                // Fetch data from network
                val charactersContainer = networkDataSource.getCharacters(pagination.offset).data
                // Save in local db
                characterDao.insertCharacters(charactersContainer.asCharacters())

                // Return data from local db
                getCharactersFromLocalDataSource().collect { characters ->
                    this.emit(Result.Success(characters))
                }
            } else {
                // Return data from local db
                getCharactersFromLocalDataSource().collect { characters ->
                    this.emit(Result.Success(characters))
                }
            }
        } catch (e: Exception) {
            val errorModel = ErrorHandling.handleError(e)
            this.emit(Result.Error(errorModel))
        }
    }.distinctUntilChanged()

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

    private fun getCharactersFromLocalDataSource(): Flow<List<Character>> =
        flow {
            characterDao.getCharacters().collect { characterEntities ->
                val characters = characterEntities.map { character ->
                    character.asDomainModel()
                }
                emit(characters)
            }
        }
}