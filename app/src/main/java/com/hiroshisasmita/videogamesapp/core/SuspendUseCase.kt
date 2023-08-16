package com.hiroshisasmita.videogamesapp.core

abstract class SuspendUseCase<Q: SuspendUseCase.RequestValues, V: SuspendUseCase.ResponseValues> {
    interface RequestValues
    interface ResponseValues

    abstract suspend fun execute(requestValues: Q): V
}