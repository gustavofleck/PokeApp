package com.gustavofleck.domain.models

data class PokemonList(
    val pokemonCount: Int,
    val nextUrl: String,
    val previousUrl: String,
    val pokemonList: List<PokemonItem>
)
