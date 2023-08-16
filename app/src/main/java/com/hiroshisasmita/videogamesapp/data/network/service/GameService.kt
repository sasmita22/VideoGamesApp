package com.hiroshisasmita.videogamesapp.data.network.service

import com.hiroshisasmita.videogamesapp.data.network.dto.GameResponse
import com.hiroshisasmita.videogamesapp.data.network.dto.PagingWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface GameService {
    @GET("games")
    suspend fun fetchGames(
        @QueryMap query: Map<String, @JvmSuppressWildcards Any>
    ): Response<PagingWrapper<GameResponse>>

    @GET("games/{id}")
    suspend fun fetchGameDetail(
        @Path("id") id: Int
    ): Response<GameResponse>
}