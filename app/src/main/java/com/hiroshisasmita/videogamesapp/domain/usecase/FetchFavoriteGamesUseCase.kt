package com.hiroshisasmita.videogamesapp.domain.usecase

import com.hiroshisasmita.videogamesapp.core.UseCase
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchFavoriteGamesUseCase @Inject constructor(
    private val repository: FavoriteRepository
): UseCase<FetchFavoriteGamesUseCase.RequestValues, FetchFavoriteGamesUseCase.ResponseValues>() {
    object RequestValues: UseCase.RequestValues
    data class ResponseValues(val result: Flow<List<GameDetailDomain>>): UseCase.ResponseValues

    override fun execute(requestValues: RequestValues): ResponseValues {
        return ResponseValues(repository.fetchFavoriteGames())
    }
}