package com.docs.rickmorty.domain.repository

import com.docs.rickmorty.data.model.responses.CharacterResponse
import com.docs.rickmorty.data.utils.Provider
import javax.inject.Inject

class DomainServiceImpl @Inject constructor() : DomainService {
    private val retrofit get() = Provider.provideRetrofit()

    override suspend fun getAllCharacters(): Pair<Int, List<CharacterResponse>> {
        val totalCharacters = 826
        val batchSize = 20
        val resultList = mutableListOf<CharacterResponse>()

        var current = 1
        while (current <= totalCharacters) {
            val end = minOf(current + batchSize - 1, totalCharacters)
            val ids = (current..end).joinToString(",")
            try {
                val batch = retrofit.getCharactersByIds(ids)
                resultList.addAll(batch)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            current += batchSize
        }

        return Pair(200, resultList)
    }


}