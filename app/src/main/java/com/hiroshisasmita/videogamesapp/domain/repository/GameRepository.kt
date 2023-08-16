package com.hiroshisasmita.videogamesapp.domain.repository

import androidx.paging.PagingData
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.model.GameDomain
import com.hiroshisasmita.videogamesapp.domain.query.GameQuery
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    fun fetchGames(gameQuery: GameQuery): Flow<PagingData<GameDomain>>
    suspend fun fetchGameDetail(id: Int): GameDetailDomain
}