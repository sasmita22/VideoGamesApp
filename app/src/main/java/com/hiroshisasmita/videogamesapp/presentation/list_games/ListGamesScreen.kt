package com.hiroshisasmita.videogamesapp.presentation.list_games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameComponent
import com.hiroshisasmita.videogamesapp.presentation.common_component.GameItem
import com.hiroshisasmita.videogamesapp.presentation.common_component.HeaderMenu
import com.hiroshisasmita.videogamesapp.presentation.common_component.RefreshLoading
import com.hiroshisasmita.videogamesapp.presentation.model.GameUiModel
import com.hiroshisasmita.videogamesapp.presentation.nav_graph.app.AppNavItem
import com.hiroshisasmita.videogamesapp.utils.height
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ListGamesScreen(navController: NavController, viewModel: ListGamesScreenViewModel = hiltViewModel()) {
    val games = viewModel.gamesPagingFlow.collectAsLazyPagingItems()

    LaunchedEffect(Unit) {
        viewModel.userStopTypingEvent
            .collectLatest {
                games.refresh()
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderMenu(title = "Games For You")
        Column {
            SearchComponent() {
                viewModel.updateSearchQuery(it)
            }
            8.height()
            ListGames(games) {
                navController.navigate(route = AppNavItem.Detail(it.id).screenRoute)
            }
        }
    }
}

@Composable
fun ListGames(lazyPagingItems: LazyPagingItems<GameUiModel>, onClick: (GameItem) -> Unit) {
    when (lazyPagingItems.loadState.refresh) {
        LoadState.Loading -> {
            RefreshLoading(modifier = Modifier.fillMaxSize())
        }
        is LoadState.Error -> {

        }
        else -> {
            LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
                items(
                    lazyPagingItems.itemCount,
                    key = lazyPagingItems.itemKey { it.id }
                ) {index ->
                    val item = lazyPagingItems[index] ?: return@items
                    GameComponent(item = item, onClick = onClick)
                }
            }
        }
    }
}

@Composable
fun SearchComponent(onTextChange: (String) -> Unit) {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        value = text,
        onValueChange = {
            text = it
            onTextChange.invoke(it)
        },
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
