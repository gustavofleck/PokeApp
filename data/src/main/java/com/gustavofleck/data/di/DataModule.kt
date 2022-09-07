package com.gustavofleck.data.di

import androidx.room.Room
import com.gustavofleck.data.api.PokemonService
import com.gustavofleck.data.api.PokemonServiceProvider.retrofitInstance
import com.gustavofleck.data.cache.database.PokemonDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "pokemon-database"

object DataModule {

    val module = module {
        factory<PokemonService> { retrofitInstance().create(PokemonService::class.java) }

        factory {
            Room.databaseBuilder(get(), PokemonDatabase::class.java, DATABASE_NAME).build()
        }
    }
}