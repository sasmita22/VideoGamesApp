package com.hiroshisasmita.videogamesapp.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hiroshisasmita.videogamesapp.presentation.nav_graph.bottom_nav.BottomNavigationGraph

@Composable
fun MainScreen(navController: NavHostController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            MainBottomNavigation(navController = bottomNavController)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            BottomNavigationGraph(mainNavController = navController, bottomNavController = bottomNavController)
        }
    }
}