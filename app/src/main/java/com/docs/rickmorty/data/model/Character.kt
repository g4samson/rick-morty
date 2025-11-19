package com.docs.rickmorty.data.model

data class Character(
  val id: Int = -1,
  val name: String = "",
  val status: String = "",
  val species: String = "",
  val gender: String = "",
  val image: String = ""
)