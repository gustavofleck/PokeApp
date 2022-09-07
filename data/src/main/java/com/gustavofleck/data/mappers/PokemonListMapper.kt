package com.gustavofleck.data.mappers

import com.gustavofleck.data.models.PokemonItemResponse
import com.gustavofleck.data.models.PokemonListResponse
import com.gustavofleck.domain.models.PokemonItem
import com.gustavofleck.domain.models.PokemonList

class PokemonListMapper(
    private val pokemonItemMapper: PokemonItemMapper
): Mapper<PokemonListResponse, PokemonList> {

    override fun map(source: PokemonListResponse): PokemonList {
        with(source) {
            return PokemonList(
                pokemonCount = pokemonCount ?: 0,
                nextUrl = nextUrl.orEmpty(),
                previousUrl = previousUrl.orEmpty(),
                pokemonList = mapPokemonList(pokemonList ?: listOf())
            )
        }
    }

    private fun mapPokemonList(pokemonItemList: List<PokemonItemResponse>): List<PokemonItem> {
        return pokemonItemList.map { pokemon -> pokemonItemMapper.map(pokemon) }
    }
}