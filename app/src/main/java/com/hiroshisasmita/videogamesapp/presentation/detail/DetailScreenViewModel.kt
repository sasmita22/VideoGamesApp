package com.hiroshisasmita.videogamesapp.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiroshisasmita.videogamesapp.core.Result
import com.hiroshisasmita.videogamesapp.core.getDataOrNull
import com.hiroshisasmita.videogamesapp.core.map
import com.hiroshisasmita.videogamesapp.core.onSuspendSuccess
import com.hiroshisasmita.videogamesapp.domain.usecase.AddFavoriteUseCase
import com.hiroshisasmita.videogamesapp.domain.usecase.FetchGameDetailUseCase
import com.hiroshisasmita.videogamesapp.domain.usecase.RemoveFavoriteUseCase
import com.hiroshisasmita.videogamesapp.presentation.model.GameDetailUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val fetchGameDetailUseCase: FetchGameDetailUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
): ViewModel() {

    private val _gameDetail by lazy { MutableStateFlow<Result<GameDetailUiModel>?>(null) }
    val gameDetail = _gameDetail.asStateFlow()

    private val _isFavorite by lazy { MutableStateFlow(false) }
    val isFavorite = _isFavorite.asStateFlow()

    fun fetchDetail(gameId: Int) {
        viewModelScope.launch {
            fetchGameDetailUseCase.execute(FetchGameDetailUseCase.RequestValues(gameId))
                .result
                .map { GameDetailUiModel.parse(it) }
                .onSuspendSuccess {
                    _isFavorite.emit(it.isFavorite)
                }.let {
                    _gameDetail.emit(it)
                }
        }
    }

    fun actionClickFavorite() {
        val currentGameDetail = gameDetail.value.getDataOrNull() ?: return
        viewModelScope.launch {
            if (isFavorite.value) actionRemoveAsFavorite(currentGameDetail)
            else actionSetAsFavorite(currentGameDetail)
        }
    }

    private suspend fun actionSetAsFavorite(currentGameDetail: GameDetailUiModel) {
        addFavoriteUseCase.execute(
            AddFavoriteUseCase.RequestValues(
                currentGameDetail.toDomain()
            )
        ).result.onSuspendSuccess { _isFavorite.emit(true) }
    }

    private suspend fun actionRemoveAsFavorite(currentGameDetail: GameDetailUiModel) {
        removeFavoriteUseCase.execute(
            RemoveFavoriteUseCase.RequestValues(currentGameDetail.id)
        ).result.onSuspendSuccess { _isFavorite.emit(false) }
    }
}