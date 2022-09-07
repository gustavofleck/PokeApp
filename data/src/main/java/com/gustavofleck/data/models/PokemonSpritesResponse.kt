package com.gustavofleck.data.models

import com.google.gson.annotations.SerializedName

data class PokemonSpritesResponse(
    @SerializedName("back_default") val backSpriteUrl: String?,
    @SerializedName("front_default") val frontSpriteUrl: String?,
)