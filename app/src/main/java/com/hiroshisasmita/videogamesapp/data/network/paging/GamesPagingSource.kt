package com.hiroshisasmita.videogamesapp.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hiroshisasmita.videogamesapp.data.database.dao.GameFavoriteDao
import com.hiroshisasmita.videogamesapp.data.network.service.GameService
import com.hiroshisasmita.videogamesapp.domain.model.GameDomain
import com.hiroshisasmita.videogamesapp.domain.query.GameQuery
import com.hiroshisasmita.videogamesapp.utils.ApiHandler

class GamesPagingSource(
    private val service: GameService,
    private val query: GameQuery
): PagingSource<Int, GameDomain>(){

    override fun getRefreshKey(state: PagingState<Int, GameDomain>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GameDomain> {
        query.page = params.key ?: GameQuery.INITIAL_PAGE

        return try {
            val pagingWrapper = ApiHandler.handleApi { service.fetchGames(query.toMap()) }
            val games = pagingWrapper?.results.orEmpty()
                .map { it.toDomain() }

            LoadResult.Page(
                data = games,
                prevKey = null,
                nextKey = if (pagingWrapper?.next != null) query.page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}