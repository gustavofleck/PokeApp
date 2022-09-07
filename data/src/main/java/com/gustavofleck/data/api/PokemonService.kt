package com.gustavofleck.data.api

import com.gustavofleck.data.models.PokemonListResponse
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon")
    suspend fun pokemonList(): PokemonListResponse

}