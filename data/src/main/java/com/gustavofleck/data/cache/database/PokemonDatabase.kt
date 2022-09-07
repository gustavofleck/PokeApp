package com.gustavofleck.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gustavofleck.data.cache.daos.PokemonDao
import com.gustavofleck.data.models.PokemonItemResponse

@Database(entities = [PokemonItemResponse::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}