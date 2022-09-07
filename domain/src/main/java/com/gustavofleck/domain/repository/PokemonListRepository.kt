package com.gustavofleck.domain.repository

import com.gustavofleck.domain.models.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {

    fun pokemonList(): Flow<PokemonList>
}