package com.hiroshisasmita.videogamesapp.domain.usecase

import com.hiroshisasmita.videogamesapp.core.Result
import com.hiroshisasmita.videogamesapp.core.SuspendUseCase
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.repository.FavoriteRepository
import javax.inject.Inject

class AddFavoriteUseCase @Inject constructor(
    private val repository: FavoriteRepository
): SuspendUseCase<AddFavoriteUseCase.RequestValues, AddFavoriteUseCase.ResponseValues>() {

    data class RequestValues(val data: GameDetailDomain): SuspendUseCase.RequestValues
    data class ResponseValues(val result: Result<Unit>): SuspendUseCase.ResponseValues

    override suspend fun execute(requestValues: RequestValues): ResponseValues {
        return try {
            repository.addFavorite(requestValues.data)
            ResponseValues(Result.Success(Unit))
        } catch (e: Exception) {
            ResponseValues(Result.Error(e))
        }
    }
}