package com.hiroshisasmita.videogamesapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain

@Entity
data class GameEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "release") val releaseDate: String,
    @ColumnInfo(name = "rating") val rating: Double,
    @ColumnInfo(name = "image_url")val imageUrl: String,
    @ColumnInfo(name = "publisher") val publisher: String,
    @ColumnInfo(name = "play_count") val playCount: Int,
    @ColumnInfo(name = "description") val description: String
) {
    companion object {
        fun parse(domain: GameDetailDomain) = GameEntity(
            id = domain.id,
            name = domain.name,
            releaseDate = domain.releaseDate,
            rating = domain.rating,
            imageUrl = domain.imageUrl,
            publisher = domain.publisher,
            playCount = domain.playCount,
            description = domain.description
        )
    }
    fun toDomain() = GameDetailDomain(
        id = this.id,
        name = this.name,
        releaseDate = this.releaseDate,
        rating = this.rating,
        imageUrl = this.imageUrl,
        publisher = this.publisher,
        playCount = this.playCount,
        description = this.description,
        isFavorite = true
    )
}
