package com.hiroshisasmita.videogamesapp.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiroshisasmita.videogamesapp.domain.usecase.FetchFavoriteGamesUseCase
import com.hiroshisasmita.videogamesapp.presentation.model.GameDetailUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoriteScreenViewModel @Inject constructor(
    fetchFavoriteGamesUseCase: FetchFavoriteGamesUseCase
): ViewModel() {

    val favoriteGames: StateFlow<List<GameDetailUiModel>> = fetchFavoriteGamesUseCase
        .execute(FetchFavoriteGamesUseCase.RequestValues)
        .result
        .map { list ->
            list.map { GameDetailUiModel.parse(it) }
        }
        .stateIn(viewModelScope, started = SharingStarted.Lazily, initialValue = listOf())

}