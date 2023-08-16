package com.hiroshisasmita.videogamesapp.presentation.nav_graph.app

sealed class AppNavItem(var screenRoute: String) {
    object Main: AppNavItem(screenRoute = "main")
    data class Detail(
        val id: Int? = null
    ): AppNavItem(screenRoute = if (id == null) "detail/{id}" else "detail/${id}")
}
