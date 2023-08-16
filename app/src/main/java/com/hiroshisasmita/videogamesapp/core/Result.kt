package com.hiroshisasmita.videogamesapp.core

sealed class Result<out T> {
    data class Success<out V>(val data: V) : Result<V>()
    data class Error(val exception: Exception): Result<Nothing>()
}

inline fun <T, R> Result<T>.map(transform: (T) -> R): Result<R> {
    return when(this) {
        is Result.Success -> {
            Result.Success(transform(this.data))
        }
        is Result.Error -> {
            this
        }
    }
}

fun <T> Result<T>?.getDataOrNull(): T? {
    return (this as? Result.Success)?.data
}

suspend fun <T> Result<T>.onSuspendSuccess(block: suspend (T) -> Unit): Result<T> {
    (this as? Result.Success)?.data?.let { block(it) }
    return this
}

