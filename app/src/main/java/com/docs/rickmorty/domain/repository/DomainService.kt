package com.docs.rickmorty.domain.repository

import com.docs.rickmorty.data.model.responses.CharacterResponse

interface DomainService {

    suspend fun getAllCharacters(): Pair<Int, List<CharacterResponse>>

//    suspend fun getCharacter(): Pair<Int, List<GetCharacterResponse>>

}