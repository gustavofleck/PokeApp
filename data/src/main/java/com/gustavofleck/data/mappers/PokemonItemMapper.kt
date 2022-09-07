package com.gustavofleck.data.mappers

import com.gustavofleck.data.models.PokemonItemResponse
import com.gustavofleck.domain.models.PokemonItem

class PokemonItemMapper: Mapper<PokemonItemResponse, PokemonItem> {

    override fun map(source: PokemonItemResponse): PokemonItem {
        with(source) {
            return PokemonItem(
                name = name.orEmpty(),
                url = url.orEmpty()
            )
        }
    }
}