package com.hiroshisasmita.videogamesapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.hiroshisasmita.videogamesapp.R
import com.hiroshisasmita.videogamesapp.core.Result
import com.hiroshisasmita.videogamesapp.presentation.common_component.RefreshError
import com.hiroshisasmita.videogamesapp.presentation.model.GameDetailUiModel
import com.hiroshisasmita.videogamesapp.utils.LoadNetworkImage
import com.hiroshisasmita.videogamesapp.utils.width

@Composable
fun DetailScreen(navController: NavController, gameId: Int?, viewModel: DetailScreenViewModel = hiltViewModel()) {

    val result = viewModel.gameDetail.collectAsStateWithLifecycle()
    val isFavorite = viewModel.isFavorite.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        gameId?.let { viewModel.fetchDetail(it) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Toolbar(
            isFavorite = isFavorite.value,
            onFavoriteClick = { viewModel.actionClickFavorite() },
            onBackPress = { navController.popBackStack() }
        )

        val resultValue = result.value ?: return@Column
        when (resultValue) {
            is Result.Success -> {
                Content(resultValue.data)
            }
            is Result.Error -> {
                RefreshError(
                    modifier = Modifier.fillMaxSize(),
                    exception = resultValue.exception
                ) {
                    gameId?.let { viewModel.fetchDetail(it) }
                }
            }
        }
    }
}

@Composable
fun Content(item: GameDetailUiModel) {
    Column {
        LoadNetworkImage(
            imageUrl = item.imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        ContentHeader(item)
        Text(
            modifier = Modifier.padding(16.dp),
            text = item.description
        )
    }
}

@Composable
fun ContentHeader(item: GameDetailUiModel) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = item.publisher,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = "Release date ${item.releaseDate}",
            style = MaterialTheme.typography.labelLarge
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(18.dp),
                imageVector = Icons.Default.Star,
                contentDescription = "star",
                tint = Color(0xFFFF9800)
            )
            4.width()
            Text(
                text = item.rating.toString(),
                style = MaterialTheme.typography.labelMedium
            )
            4.width()
            Icon(
                modifier = Modifier
                    .size(18.dp),
                painter = painterResource(id = R.drawable.ic_game_controller),
                contentDescription = "console"
            )
            4.width()
            Text(
                text = "${item.playCount} Played",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
fun Toolbar(
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onBackPress: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(vertical = 6.dp, horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackPress) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back_icon",
                tint = Color.White
            )
        }
        16.width()
        Text(
            text = "Detail",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = Color.White
        )
        16.width()
        IconButton(onClick = onFavoriteClick) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "fav_icon",
                tint = Color.White
            )
        }
    }
}
