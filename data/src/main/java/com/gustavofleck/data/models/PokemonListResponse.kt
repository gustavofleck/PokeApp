package com.gustavofleck.data.models

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count") val pokemonCount: Int?,
    @SerializedName("next") val nextUrl: String?,
    @SerializedName("previous")val previousUrl: String?,
    @SerializedName("results") val pokemonList: List<PokemonItemResponse>?
)