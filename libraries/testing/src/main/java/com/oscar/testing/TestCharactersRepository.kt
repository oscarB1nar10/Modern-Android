package com.oscar.testing

import com.oscar.comon.result.Result
import com.oscar.data.repository.CharactersRepository
import com.oscar.model.Character
import com.oscar.model.Pagination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestCharactersRepository : CharactersRepository {

    private val count = 20
    private val limit = 20
    private val offset = 0
    private val total = 1562

    private val characters = mutableListOf(
        Character(
            id = 1011334,
            name = "3-D Man",
            description = "",
            image = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
            pagination = Pagination(
                count = count,
                limit = limit,
                offset = offset,
                total = total
            )
        ),
        Character(
            id = 1017100,
            name = "A-Bomb (HAS)",
            description = "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
            image = "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
            pagination = Pagination(
                count = count,
                limit = limit,
                offset = offset,
                total = total
            )
        )
    )

    override fun getCharacters(pagination: Pagination): Flow<Result<List<Character>>> = flow {
        emit(Result.Success(characters))
    }

    override suspend fun getCharacterById(characterId: Int): Result<Character> {
        val character = characters.firstOrNull { it.id == characterId } ?: Character()
        return Result.Success(character)
    }
}