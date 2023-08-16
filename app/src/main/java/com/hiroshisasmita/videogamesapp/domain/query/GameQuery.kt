package com.hiroshisasmita.videogamesapp.domain.query

data class GameQuery(
    var page: Int = INITIAL_PAGE,
    var pageSize: Int = PAGE_SIZE,
    var search: String? = null
) {
    companion object {
        const val PAGE_SIZE = 10
        const val INITIAL_PAGE = 1
    }

    fun toMap(): Map<String, Any> {
        val map = mutableMapOf<String, Any>()
        map["page"] = page
        map["page_size"] = pageSize
        search?.takeIf { it.isNotBlank() }?.let {
            map["search"] = it
        }

        return map
    }
}
