package com.hiroshisasmita.videogamesapp.domain.usecase

import androidx.paging.PagingData
import com.hiroshisasmita.videogamesapp.core.UseCase
import com.hiroshisasmita.videogamesapp.domain.model.GameDomain
import com.hiroshisasmita.videogamesapp.domain.query.GameQuery
import com.hiroshisasmita.videogamesapp.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchListGamesUseCase @Inject constructor(
    private val repository: GameRepository
): UseCase<FetchListGamesUseCase.RequestValues, FetchListGamesUseCase.ResponseValues>() {
    data class RequestValues(val query: GameQuery): UseCase.RequestValues
    data class ResponseValues(val result: Flow<PagingData<GameDomain>>): UseCase.ResponseValues

    override fun execute(requestValues: RequestValues): ResponseValues {
        return ResponseValues(repository.fetchGames(requestValues.query))
    }
}