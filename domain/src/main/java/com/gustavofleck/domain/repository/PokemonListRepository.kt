package com.gustavofleck.domain.repository

import com.gustavofleck.domain.models.PokemonList
import com.gustavofleck.domain.models.PokemonListViewObject
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {

    fun pokemonList(): Flow<PokemonListViewObject>
}