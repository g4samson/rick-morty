package com.docs.rickmorty.data.utils

import com.docs.rickmorty.data.model.Character
import retrofit2.http.GET

interface RetrofitApi {
    @GET("character")
    suspend fun getCharacters(): List<Character>
}