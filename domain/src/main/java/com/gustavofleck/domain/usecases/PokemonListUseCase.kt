package com.gustavofleck.domain.usecases

import com.gustavofleck.domain.models.PokemonList
import com.gustavofleck.domain.repository.PokemonListRepository
import kotlinx.coroutines.flow.Flow

class PokemonListUseCase(
    private val repository: PokemonListRepository
) {

    operator fun invoke(): Flow<PokemonList> {
        return repository.pokemonList()
    }
}