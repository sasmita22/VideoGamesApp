package com.hiroshisasmita.videogamesapp.domain.model

data class GameDomain(
    val id: Int,
    val name: String,
    val releaseDate: String,
    val rating: Double,
    val imageUrl: String
)
