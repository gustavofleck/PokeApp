package com.gustavofleck.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.gustavofleck.data.models.PokemonItemResponse
import com.gustavofleck.data.models.PokemonListResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemons")
    fun getPokemons(): Flow<List<PokemonItemResponse>>

    @Insert
    fun insertPokemons(vararg pokemons: PokemonItemResponse)
}