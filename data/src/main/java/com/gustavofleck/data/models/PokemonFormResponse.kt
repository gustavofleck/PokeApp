package com.gustavofleck.data.models

import com.google.gson.annotations.SerializedName

data class PokemonFormResponse(
    @SerializedName("sprites") val sprites: PokemonSpritesResponse
)