package com.hiroshisasmita.videogamesapp.di

import android.content.Context
import androidx.room.Room
import com.hiroshisasmita.videogamesapp.data.database.AppDatabase
import com.hiroshisasmita.videogamesapp.data.database.dao.GameFavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesGameFavoriteDao(appDatabase: AppDatabase): GameFavoriteDao {
        return appDatabase.gameFavoriteDao()
    }
}