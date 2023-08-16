package com.hiroshisasmita.videogamesapp.presentation.list_games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.hiroshisasmita.videogamesapp.domain.query.GameQuery
import com.hiroshisasmita.videogamesapp.domain.usecase.FetchListGamesUseCase
import com.hiroshisasmita.videogamesapp.presentation.model.GameUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class ListGamesScreenViewModel @Inject constructor(
    fetchListGamesUseCase: FetchListGamesUseCase
) : ViewModel() {

    private val gameQuery by lazy {
        GameQuery()
    }

    private val _keywordChanges by lazy { MutableStateFlow<String?>(null) }

    private val _userStopTypingEvent by lazy { MutableSharedFlow<Unit>() }
    val userStopTypingEvent = _userStopTypingEvent.asSharedFlow()

    init {
        viewModelScope.launch {
            _keywordChanges
                .debounce(1000)
                .filterNotNull()
                .collectLatest {
                    gameQuery.search = it
                    _userStopTypingEvent.emit(Unit)
                }
        }
    }

    val gamesPagingFlow = fetchListGamesUseCase.execute(FetchListGamesUseCase.RequestValues(gameQuery))
        .result
        .map { pagingData ->
            pagingData.map { GameUiModel.parse(it) }
        }.cachedIn(viewModelScope)

    fun updateSearchQuery(keyword: String) {
        viewModelScope.launch {
            _keywordChanges.emit(keyword)
        }
    }
}