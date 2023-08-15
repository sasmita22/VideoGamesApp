package com.hiroshisasmita.videogamesapp.presentation.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameComponent
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameItem
import com.hiroshisasmita.videogamesapp.presentation.common_component.HeaderMenu
import com.hiroshisasmita.videogamesapp.presentation.model.GameUiModel
import com.hiroshisasmita.videogamesapp.presentation.nav_graph.app.AppNavItem

@Composable
fun FavoriteScreen(mainNavController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderMenu(title = "Favorite Games")
        FavoriteListItems {
            mainNavController.navigate(AppNavItem.Detail.screenRoute)
        }
    }
}

@Composable
fun FavoriteListItems(onClick: (GameItem) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
        items(GameUiModel.createDummy()) {
            GameComponent(item = it) { item -> onClick.invoke(item) }
        }
    }
}
