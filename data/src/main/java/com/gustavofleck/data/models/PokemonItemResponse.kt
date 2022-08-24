package com.gustavofleck.data.models

import com.google.gson.annotations.SerializedName

data class PokemonItemResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)