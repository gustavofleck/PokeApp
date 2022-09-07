package com.gustavofleck.domain.usecases

import com.gustavofleck.domain.models.PokemonListViewObject
import com.gustavofleck.domain.repository.PokemonListRepository
import kotlinx.coroutines.flow.Flow

class PokemonListUseCase(
    private val repository: PokemonListRepository
) {

    operator fun invoke(): Flow<PokemonListViewObject> {
        return repository.pokemonList()
    }
}