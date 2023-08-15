package com.hiroshisasmita.videogamesapp.presentation.nav_graph.bottom_nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hiroshisasmita.videogamesapp.presentation.favorite.FavoriteScreen
import com.hiroshisasmita.videogamesapp.presentation.list_games.ListGamesScreen

@Composable
fun BottomNavigationGraph(mainNavController: NavHostController, bottomNavController: NavHostController) {
    NavHost(navController = bottomNavController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            ListGamesScreen(mainNavController)
        }
        composable(BottomNavItem.Favorite.screenRoute) {
            FavoriteScreen(mainNavController)
        }
    }
}