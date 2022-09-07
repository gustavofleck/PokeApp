package com.gustavofleck.data.datasources

import com.gustavofleck.data.api.PokemonService
import com.gustavofleck.data.mappers.PokemonFormMapper
import com.gustavofleck.domain.models.PokemonForm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonFormDataSource(
    private val service: PokemonService,
    private val mapper: PokemonFormMapper
) {

    fun pokemonForm(name: String): Flow<PokemonForm> {
        return flow {
            val response = service.pokemonForm(name)
            emit(mapper.map(response))
        }
    }

}