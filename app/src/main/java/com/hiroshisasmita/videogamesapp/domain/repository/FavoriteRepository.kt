package com.hiroshisasmita.videogamesapp.domain.repository

import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.model.GameDomain
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun fetchFavoriteGames(): Flow<List<GameDetailDomain>>
    suspend fun deleteFavorite(id: Int)
    suspend fun addFavorite(game: GameDetailDomain)
}