package com.hiroshisasmita.videogamesapp.presentation.model

import com.hiroshisasmita.videogamesapp.domain.model.GameDomain
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameItem

data class GameUiModel(
    override val id: Int,
    override val name: String,
    override val releaseDate: String,
    override val rating: Double,
    override val imageUrl: String
): GameItem {
    companion object {
        fun parse(domain: GameDomain) = GameUiModel(
            id = domain.id,
            name = domain.name,
            releaseDate = domain.releaseDate,
            rating = domain.rating,
            imageUrl = domain.imageUrl
        )
    }
}
