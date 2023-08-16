package com.hiroshisasmita.videogamesapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class PagingWrapper<T>(
    @SerializedName("next") val next: String?,
    @SerializedName("results") val results: List<T>
)
