package com.hiroshisasmita.videogamesapp.core

abstract class UseCase<Q: UseCase.RequestValues, V: UseCase.ResponseValues> {
    interface RequestValues
    interface ResponseValues

    abstract fun execute(requestValues: Q): V
}