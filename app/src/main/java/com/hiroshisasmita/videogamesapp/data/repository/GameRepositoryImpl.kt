package com.hiroshisasmita.videogamesapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hiroshisasmita.videogamesapp.data.database.dao.GameFavoriteDao
import com.hiroshisasmita.videogamesapp.data.network.paging.GamesPagingSource
import com.hiroshisasmita.videogamesapp.data.network.service.GameService
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.model.GameDomain
import com.hiroshisasmita.videogamesapp.domain.query.GameQuery
import com.hiroshisasmita.videogamesapp.domain.repository.GameRepository
import com.hiroshisasmita.videogamesapp.utils.ApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GameRepositoryImpl(
    private val gameService: GameService,
    private val dao: GameFavoriteDao
): GameRepository {
    override fun fetchGames(gameQuery: GameQuery): Flow<PagingData<GameDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = GameQuery.PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GamesPagingSource(gameService, gameQuery)
            }
        ).flow
    }

    override suspend fun fetchGameDetail(id: Int): GameDetailDomain = withContext(Dispatchers.IO) {
        val data = ApiHandler.handleApi {
            gameService.fetchGameDetail(id)
        }
        val isFavorite = data?.id?.let { dao.fetchGameById(it) } != null
        return@withContext data?.toDetailDomain(isFavorite) ?: throw Exception("Data not found")
    }
}