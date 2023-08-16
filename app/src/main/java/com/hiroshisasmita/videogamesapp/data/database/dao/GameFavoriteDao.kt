package com.hiroshisasmita.videogamesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hiroshisasmita.videogamesapp.data.database.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameFavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(gameEntity: GameEntity)

    @Query("DELETE FROM GameEntity WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM GameEntity")
    fun fetchFavorites(): Flow<List<GameEntity>>

    @Query("SELECT * FROM GameEntity WHERE id = :id")
    fun fetchGameById(id: Int): GameEntity?
}