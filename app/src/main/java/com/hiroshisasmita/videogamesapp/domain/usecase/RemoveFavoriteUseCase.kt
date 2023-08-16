package com.hiroshisasmita.videogamesapp.domain.usecase

import com.hiroshisasmita.videogamesapp.core.Result
import com.hiroshisasmita.videogamesapp.core.SuspendUseCase
import com.hiroshisasmita.videogamesapp.domain.repository.FavoriteRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(
    private val repository: FavoriteRepository
): SuspendUseCase<RemoveFavoriteUseCase.RequestValues, RemoveFavoriteUseCase.ResponseValues>() {

    data class RequestValues(val id: Int): SuspendUseCase.RequestValues
    data class ResponseValues(val result: Result<Unit>): SuspendUseCase.ResponseValues

    override suspend fun execute(requestValues: RequestValues): ResponseValues {
        return try {
            repository.deleteFavorite(requestValues.id)
            ResponseValues(Result.Success(Unit))
        } catch (e: Exception) {
            ResponseValues(Result.Error(e))
        }
    }
}