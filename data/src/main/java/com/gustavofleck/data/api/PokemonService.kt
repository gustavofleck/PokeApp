package com.gustavofleck.data.api

import com.gustavofleck.data.models.PokemonFormResponse
import com.gustavofleck.data.models.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon")
    suspend fun pokemonList(): PokemonListResponse

    @GET("pokemon-form/{name}/")
    suspend fun pokemonForm(@Path("name") pokemonName: String): PokemonFormResponse

}