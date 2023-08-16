package com.hiroshisasmita.videogamesapp.domain.usecase

import com.hiroshisasmita.videogamesapp.core.Result
import com.hiroshisasmita.videogamesapp.core.SuspendUseCase
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.repository.GameRepository
import javax.inject.Inject

class FetchGameDetailUseCase @Inject constructor(
    private val repository: GameRepository
): SuspendUseCase<FetchGameDetailUseCase.RequestValues, FetchGameDetailUseCase.ResponseValues>() {

    data class RequestValues(val id: Int): SuspendUseCase.RequestValues
    data class ResponseValues(val result: Result<GameDetailDomain>): SuspendUseCase.ResponseValues

    override suspend fun execute(requestValues: RequestValues): ResponseValues {
        return try {
            val gameDetail = repository.fetchGameDetail(requestValues.id)
            ResponseValues(Result.Success(gameDetail))
        } catch (e: Exception) {
            ResponseValues(Result.Error(e))
        }
    }
}