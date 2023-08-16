package com.hiroshisasmita.videogamesapp.presentation.model

import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameItem

data class GameDetailUiModel(
    override val id: Int,
    override val name: String,
    override val releaseDate: String,
    override val rating: Double,
    override val imageUrl: String,
    val publisher: String,
    val playCount: Int,
    val description: String,
    val isFavorite: Boolean
): GameItem {
    companion object {
        fun parse(domain: GameDetailDomain) = GameDetailUiModel(
            id = domain.id,
            name = domain.name,
            releaseDate = domain.releaseDate,
            rating = domain.rating,
            imageUrl = domain.imageUrl,
            publisher = domain.publisher,
            playCount = domain.playCount,
            description = domain.description,
            isFavorite = domain.isFavorite
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
        isFavorite = this.isFavorite
    )
}
