package com.gustavofleck.presentation.viewstate

import com.gustavofleck.domain.models.PokemonItem

sealed class PokemonListViewState {

    object GenericError: PokemonListViewState()
    object NoInternetError: PokemonListViewState()
    object Loading: PokemonListViewState()
    data class Success(val pokemonList: List<PokemonItem>): PokemonListViewState()

}