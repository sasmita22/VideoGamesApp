package com.hiroshisasmita.videogamesapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hiroshisasmita.videogamesapp.R
import com.hiroshisasmita.videogamesapp.presentation.model.GameUiModel
import com.hiroshisasmita.videogamesapp.utils.LoadNetworkImage
import com.hiroshisasmita.videogamesapp.utils.width

@Composable
fun DetailScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar { navController.popBackStack() }
        Content()
    }
}

@Composable
fun Content() {
    val item = GameUiModel.createDummy().first()
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
fun ContentHeader(item: GameUiModel) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = item.publisher)
        Text(text = item.title)
        Text(text = "Release date ${item.releaseDate}")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(14.dp),
                imageVector = Icons.Default.Star,
                contentDescription = "star",
                tint = Color(0xFFFF9800)
            )
            4.width()
            Text(
                text = item.rating,
                style = MaterialTheme.typography.labelSmall
            )
            4.width()
            Icon(
                modifier = Modifier
                    .size(14.dp),
                painter = painterResource(id = R.drawable.ic_game_controller),
                contentDescription = "console"
            )
            4.width()
            Text(
                text = "${item.countPlayed} Played",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun Toolbar(
    onBackPress: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(vertical = 6.dp, horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackPress() }) {
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
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "fav_icon",
                tint = Color.White
            )
        }
    }
}
