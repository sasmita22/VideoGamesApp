package com.hiroshisasmita.videogamesapp.domain.model

data class GameDetailDomain(
    val id: Int,
    val name: String,
    val releaseDate: String,
    val rating: Double,
    val imageUrl: String,
    val publisher: String,
    val playCount: Int,
    val description: String,
    val isFavorite: Boolean
)
