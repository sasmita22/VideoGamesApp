package com.hiroshisasmita.videogamesapp.presentation.list_games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameComponent
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameItem
import com.hiroshisasmita.videogamesapp.presentation.common_component.HeaderMenu
import com.hiroshisasmita.videogamesapp.presentation.model.GameUiModel
import com.hiroshisasmita.videogamesapp.utils.height

@Composable
fun ListGamesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderMenu(title = "Games For You")
        Column {
            SearchComponent()
            ListGames {
                navController.navigate(route = "detail")
            }
        }
    }
}

@Composable
fun ListGames(onClick: (GameItem) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(GameUiModel.createDummy()) {
            GameComponent(item = it, onClick = onClick)
        }
    }
}

@Composable
fun SearchComponent() {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        value = "",
        onValueChange = {},
        placeholder = { Text(text = "Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search icon"
            )
        },
        shape = RoundedCornerShape(24.dp)
    )
}
