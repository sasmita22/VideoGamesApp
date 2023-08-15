package com.hiroshisasmita.videogamesapp.presentation.list_games

import androidx.lifecycle.ViewModel
import com.hiroshisasmita.videogamesapp.presentation.model.GameUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListGamesScreenViewModel @Inject constructor(): ViewModel() {
    private val _games by lazy { MutableStateFlow<List<GameUiModel>>(listOf()) }
    val games = _games.asStateFlow()

    init {

    }
}