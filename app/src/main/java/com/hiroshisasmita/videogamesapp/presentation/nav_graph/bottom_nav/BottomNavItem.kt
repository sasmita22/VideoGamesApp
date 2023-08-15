package com.hiroshisasmita.videogamesapp.presentation.nav_graph.bottom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title: String, var icon: ImageVector, var screenRoute: String) {
    object Home: BottomNavItem(title = "Home", icon = Icons.Outlined.Home, screenRoute = "home")
    object Favorite: BottomNavItem(title = "Favorite", icon = Icons.Outlined.FavoriteBorder, screenRoute = "favorite")
}
