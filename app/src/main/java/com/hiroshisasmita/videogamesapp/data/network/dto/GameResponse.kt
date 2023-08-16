package com.hiroshisasmita.videogamesapp.data.network.dto
import com.google.gson.annotations.SerializedName
import com.hiroshisasmita.videogamesapp.domain.model.GameDetailDomain
import com.hiroshisasmita.videogamesapp.domain.model.GameDomain


data class GameResponse(
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("description_raw")
    val descriptionRaw: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("publishers")
    val publishers: List<Publisher>?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("released")
    val released: String?,
    @SerializedName("stores")
    val stores: List<Store>?
) {
    fun toDomain() = GameDomain (
        id = this.id ?: -1,
        name = this.name.orEmpty(),
        releaseDate = this.released.orEmpty(),
        rating = this.rating ?: 0.0,
        imageUrl = this.backgroundImage.orEmpty()
    )
    fun toDetailDomain(isFavorite: Boolean) = GameDetailDomain (
        id = this.id ?: -1,
        name = this.name.orEmpty(),
        releaseDate = this.released.orEmpty(),
        rating = this.rating ?: 0.0,
        imageUrl = this.backgroundImage.orEmpty(),
        publisher = this.publishers?.firstOrNull()?.name.orEmpty(),
        description = this.descriptionRaw.orEmpty(),
        playCount = this.stores?.firstOrNull()?.store?.gamesCount ?: 0,
        isFavorite = isFavorite
    )
}

data class Publisher(
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_background")
    val imageBackground: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)

data class Store(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("store")
    val store: StoreDetail?,
    @SerializedName("url")
    val url: String?
)

data class StoreDetail(
    @SerializedName("domain")
    val domain: String?,
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_background")
    val imageBackground: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)