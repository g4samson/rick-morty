package com.docs.rickmorty.data.utils

import com.docs.rickmorty.data.model.responses.CharacterResponse
import com.docs.rickmorty.data.model.responses.GetAllCharactersResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {
    @GET("character/{ids}")
    suspend fun getCharactersByIds(
        @Path("ids") ids: String
    ): List<CharacterResponse>
}