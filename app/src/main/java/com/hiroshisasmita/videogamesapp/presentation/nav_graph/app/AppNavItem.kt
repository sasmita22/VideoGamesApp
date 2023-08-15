package com.hiroshisasmita.videogamesapp.presentation.nav_graph.app

sealed class AppNavItem(var screenRoute: String) {
    object Main: AppNavItem(screenRoute = "main")
    object Detail: AppNavItem(screenRoute = "detail")
}
