package com.example.moviesapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.moviesapp.ui.theme.black
import com.example.moviesapp.ui.theme.textF16W500

@Composable
fun MovieTile(
    imageUrl: String,
    title: String,
    posterWidth: Dp,
    posterHeight: Dp,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
){
    Column(modifier = modifier
        .padding(8.dp)
        .clickable(enabled = onClick != null) {
            onClick?.invoke()
        }) {
        MoviePoster(
            imageUrl = imageUrl,
            width = posterWidth,
            height = posterHeight
        )

        Text(
            text = title,
            modifier = Modifier.padding(top = 6.dp),
            style = textF16W500.copy(color = black, )
        )
    }
}