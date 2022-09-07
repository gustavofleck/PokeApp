package com.gustavofleck.pokeapp.features.pokemonlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gustavofleck.domain.models.PokemonItem
import com.gustavofleck.domain.models.PokemonItemViewObject
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PokemonList(navController: NavHostController, pokemons: List<PokemonItemViewObject>) {
    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonListItem(pokemon)
        }
    }
}

@Composable
fun PokemonListItem(pokemon: PokemonItemViewObject) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Row {
            GlideImage(imageModel = pokemon.imageUrl, contentScale = ContentScale.Crop)
            Text(text = pokemon.name)
        }
    }
}

@Preview
@Composable
fun PreviewPokemonItem() {
    PokemonListItem(
        pokemon = PokemonItemViewObject(
            "Carina",
            "",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
        )
    )
}
