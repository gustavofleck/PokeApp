package com.gustavofleck.data.repository

import com.gustavofleck.data.datasources.PokemonFormDataSource
import com.gustavofleck.data.datasources.PokemonListDataSource
import com.gustavofleck.domain.models.PokemonItemViewObject
import com.gustavofleck.domain.models.PokemonList
import com.gustavofleck.domain.models.PokemonListViewObject
import com.gustavofleck.domain.repository.PokemonListRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
class PokemonListRepositoryImpl(
    private val pokemonListDataSource: PokemonListDataSource,
    private val pokemonFormDataSource: PokemonFormDataSource
) : PokemonListRepository {

    override fun pokemonList(): Flow<PokemonListViewObject> {
        return pokemonListDataSource.pokemonList().flatMapMerge { response ->
            flow {
                PokemonListViewObject(
                    nextUrl = response.nextUrl,
                    previousUrl = response.previousUrl,
                    pokemons = setupPokemonItemImage(response)
                )
            }
        }
    }

    private suspend fun setupPokemonItemImage(response: PokemonList) =
        response.pokemonList.map { pokemon ->
            val pokemonForm = pokemonFormDataSource.pokemonForm(pokemon.name).first()
            PokemonItemViewObject(
                name = pokemon.name,
                url = pokemon.url,
                imageUrl = pokemonForm.sprites.frontSpriteUrl
            )
        }
}