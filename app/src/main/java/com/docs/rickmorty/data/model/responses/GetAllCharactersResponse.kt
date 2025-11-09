package com.docs.rickmorty.data.model.responses

data class GetAllCharactersResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)

data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)