package com.hiroshisasmita.videogamesapp.presentation.nav_graph.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hiroshisasmita.videogamesapp.presentation.detail.DetailScreen
import com.hiroshisasmita.videogamesapp.presentation.main.MainScreen

@Composable
fun AppNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppNavItem.Main.screenRoute) {
        composable(AppNavItem.Main.screenRoute) {
            MainScreen(navController)
        }
        composable(
            route = AppNavItem.Detail().screenRoute,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { entry ->
            val gameId = entry.arguments?.getInt("id")
            DetailScreen(navController = navController, gameId = gameId)
        }
    }
}