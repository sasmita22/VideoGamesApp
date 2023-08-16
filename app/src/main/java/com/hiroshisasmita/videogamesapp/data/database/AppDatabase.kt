package com.hiroshisasmita.videogamesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hiroshisasmita.videogamesapp.data.database.dao.GameFavoriteDao
import com.hiroshisasmita.videogamesapp.data.database.entity.GameEntity

@Database(
    entities =[
        GameEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "app-database"
    }

    abstract fun gameFavoriteDao(): GameFavoriteDao
}