package com.gustavofleck.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gustavofleck.domain.models.PokemonListViewObject
import com.gustavofleck.domain.usecases.PokemonListUseCase
import com.gustavofleck.presentation.viewstate.PokemonListViewState
import com.gustavofleck.presentation.viewstate.PokemonListViewState.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val pokemonListUseCase: PokemonListUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val pokemonListMutableLiveData = MutableLiveData<PokemonListViewState>()
    val pokemonListLiveData: LiveData<PokemonListViewState> = pokemonListMutableLiveData

    fun pokemonList() {
        viewModelScope.launch {
            pokemonListUseCase()
                .flowOn(dispatcher)
                .onStart { loadingState() }
                .catch { handleErrorState(it) }
                .collect { handleSuccessState(it) }
        }
    }

    private fun handleSuccessState(result: PokemonListViewObject) {
        pokemonListMutableLiveData.value = Success(result.pokemons)
    }

    private fun handleErrorState(error: Throwable) {
        pokemonListMutableLiveData.value = GenericError
    }

    private fun loadingState() {
        pokemonListMutableLiveData.value = Loading
    }

}