package com.hiroshisasmita.videogamesapp.presentation.common_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiroshisasmita.videogamesapp.presentation.model.GameUiModel
import com.hiroshisasmita.videogamesapp.utils.LoadNetworkImage
import com.hiroshisasmita.videogamesapp.utils.width

@Composable
fun GameComponent(item: GameItem, onClick: (GameItem) -> Unit = {}) {
    Row(
        modifier = Modifier
            .clickable(
                indication = rememberRipple(bounded = true),
                onClick = {
                    onClick.invoke(item)
                },
                interactionSource = remember { MutableInteractionSource() }
            ).padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        LoadNetworkImage(
            imageUrl = item.imageUrl,
            modifier = Modifier
                .width(120.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(6.dp))
        )

        12.width()

        Column(
            modifier = Modifier
                .weight(1f)
                .height(IntrinsicSize.Max)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Release date: ${item.releaseDate}",
                style = MaterialTheme.typography.labelSmall
            )
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
            }
        }
    }
}

@Preview
@Composable
fun ComponentPreview() {
    val item = GameUiModel.createDummy().first()

    GameComponent(item = item)
}