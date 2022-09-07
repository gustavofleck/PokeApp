package com.gustavofleck.data.datasources

import com.gustavofleck.data.api.PokemonService
import com.gustavofleck.data.mappers.PokemonListMapper
import com.gustavofleck.domain.models.PokemonList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonListDataSource(
    private val service: PokemonService,
    private val mapper: PokemonListMapper
) {

    fun pokemonList(): Flow<PokemonList> {
        return flow {
            val response = service.pokemonList()
            emit(mapper.map(response))
        }
    }

}