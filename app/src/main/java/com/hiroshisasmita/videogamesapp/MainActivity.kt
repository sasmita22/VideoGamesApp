package com.hiroshisasmita.videogamesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.hiroshisasmita.videogamesapp.presentation.main.MainScreen
import com.hiroshisasmita.videogamesapp.presentation.nav_graph.app.AppNavigationGraph
import com.hiroshisasmita.videogamesapp.ui.theme.VideoGamesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            VideoGamesAppTheme {
                AppNavigationGraph(navController = navController)
            }
        }
    }
}