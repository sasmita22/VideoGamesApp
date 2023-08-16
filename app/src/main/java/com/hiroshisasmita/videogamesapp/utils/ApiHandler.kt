package com.hiroshisasmita.videogamesapp.utils

import retrofit2.Response

object ApiHandler {

    suspend fun <T: Any> handleApi(block: suspend () -> Response<T>): T? {
        val response = block()
        if (response.isSuccessful.not()) throw Exception()
        return response.body()
    }
}