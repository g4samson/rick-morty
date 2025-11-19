package com.docs.rickmorty.data.utils

import com.docs.rickmorty.data.model.responses.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitRepository {
    @GET("character/{ids}")
    suspend fun getCharactersByIds(
        @Path("ids") ids: String
    ): List<CharacterResponse>
}