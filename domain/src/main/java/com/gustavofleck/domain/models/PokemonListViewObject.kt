package com.gustavofleck.domain.models

data class PokemonListViewObject(
    val nextUrl: String,
    val previousUrl: String,
    val pokemons: List<PokemonItemViewObject>
)