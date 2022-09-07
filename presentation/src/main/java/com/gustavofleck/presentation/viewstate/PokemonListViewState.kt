package com.gustavofleck.presentation.viewstate

import com.gustavofleck.domain.models.PokemonItemViewObject

sealed class PokemonListViewState {

    object GenericError: PokemonListViewState()
    object NoInternetError: PokemonListViewState()
    object Loading: PokemonListViewState()
    data class Success(val pokemonList: List<PokemonItemViewObject>): PokemonListViewState()

}