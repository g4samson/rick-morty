package com.docs.rickmorty.domain.repository

import com.docs.rickmorty.data.model.responses.CharacterResponse
import com.docs.rickmorty.data.model.responses.GetAllCharactersResponse
import com.docs.rickmorty.data.model.responses.GetCharacterResponse

interface DomainRepository {

    suspend fun getAllCharacters(): Pair<Int, List<CharacterResponse>>

//    suspend fun getCharacter(): Pair<Int, List<GetCharacterResponse>>

}