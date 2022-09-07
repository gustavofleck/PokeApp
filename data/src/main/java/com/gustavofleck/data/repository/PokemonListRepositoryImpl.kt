package com.gustavofleck.data.repository

import com.gustavofleck.data.datasources.PokemonListDataSource
import com.gustavofleck.domain.models.PokemonList
import com.gustavofleck.domain.repository.PokemonListRepository
import kotlinx.coroutines.flow.Flow

class PokemonListRepositoryImpl(
    private val dataSource: PokemonListDataSource
): PokemonListRepository {

    override fun pokemonList(): Flow<PokemonList> {
        return dataSource.pokemonList()
    }
}