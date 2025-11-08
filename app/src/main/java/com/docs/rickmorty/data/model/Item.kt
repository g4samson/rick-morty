package com.docs.rickmorty.data.model

import com.google.gson.annotations.SerializedName


data class Item (

  @SerializedName("info"    ) var info    : Info?              = Info(),
  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)