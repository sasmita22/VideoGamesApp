package com.hiroshisasmita.videogamesapp.data.repository

import com.hiroshisasmita.videogamesapp.data.database.dao.GameFavoriteDao
import com.hiroshisasmita.videogamesapp.data.database.entity.GameEntity
import com.hiroshisasmita.videogamesapp.data.network.service.GameService
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.model.GameDomain
import com.hiroshisasmita.videogamesapp.domain.repository.FavoriteRepository
import com.hiroshisasmita.videogamesapp.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(
    private val dao: GameFavoriteDao
): FavoriteRepository {
    override fun fetchFavoriteGames(): Flow<List<GameDetailDomain>> {
        return dao.fetchFavorites()
            .map { list ->
                list.map { it.toDomain() }
            }
    }

    override suspend fun deleteFavorite(id: Int) {
        dao.delete(id)
    }

    override suspend fun addFavorite(game: GameDetailDomain) {
        dao.insertOrUpdate(GameEntity.parse(game))
    }
}