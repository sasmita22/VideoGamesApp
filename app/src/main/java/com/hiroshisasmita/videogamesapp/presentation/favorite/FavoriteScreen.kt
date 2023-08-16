package com.hiroshisasmita.videogamesapp.presentation.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameComponent
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameItem
import com.hiroshisasmita.videogamesapp.presentation.common_component.HeaderMenu
import com.hiroshisasmita.videogamesapp.presentation.model.GameDetailUiModel
import com.hiroshisasmita.videogamesapp.presentation.nav_graph.app.AppNavItem

@Composable
fun FavoriteScreen(mainNavController: NavHostController, viewModel: FavoriteScreenViewModel = hiltViewModel()) {
    val games = viewModel.favoriteGames.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderMenu(title = "Favorite Games")
        FavoriteListItems(
            modifier = Modifier.weight(1f),
            favoriteGames = games.value
        ) {
            mainNavController.navigate(AppNavItem.Detail(it.id).screenRoute)
        }
    }
}

@Composable
fun FavoriteListItems(modifier: Modifier, favoriteGames: List<GameDetailUiModel>, onClick: (GameItem) -> Unit) {
    Column(
        modifier
    ) {
        if (favoriteGames.isEmpty()) {
            EmptyState()
            return
        }

        LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
            items(favoriteGames) {
                GameComponent(item = it) { item -> onClick.invoke(item) }
            }
        }
    }
}

@Composable
fun EmptyState() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Favorite Game is Empty")
    }
}
