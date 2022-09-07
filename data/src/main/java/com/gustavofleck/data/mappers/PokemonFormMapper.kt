package com.gustavofleck.data.mappers

import com.gustavofleck.data.models.PokemonFormResponse
import com.gustavofleck.domain.models.PokemonForm
import com.gustavofleck.domain.models.PokemonSprites

class PokemonFormMapper: Mapper<PokemonFormResponse, PokemonForm> {
    override fun map(source: PokemonFormResponse): PokemonForm {
        return PokemonForm(
            PokemonSprites(
                frontSpriteUrl = source.sprites.frontSpriteUrl.orEmpty(),
                backSpriteUrl = source.sprites.backSpriteUrl.orEmpty()
            )
        )
    }
}