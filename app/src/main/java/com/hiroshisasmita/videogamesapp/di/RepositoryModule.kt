package com.hiroshisasmita.videogamesapp.di

import com.hiroshisasmita.videogamesapp.data.database.dao.GameFavoriteDao
import com.hiroshisasmita.videogamesapp.data.network.service.GameService
import com.hiroshisasmita.videogamesapp.data.repository.FavoriteRepositoryImpl
import com.hiroshisasmita.videogamesapp.data.repository.GameRepositoryImpl
import com.hiroshisasmita.videogamesapp.domain.repository.FavoriteRepository
import com.hiroshisasmita.videogamesapp.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesGameRepository(
        gameService: GameService,
        dao: GameFavoriteDao
    ): GameRepository {
        return GameRepositoryImpl(gameService, dao)
    }

    @Provides
    @Singleton
    fun providesFavoriteRepository(
        dao: GameFavoriteDao
    ): FavoriteRepository {
        return FavoriteRepositoryImpl(dao)
    }
}