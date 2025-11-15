package com.example.moviesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesapp.ui.theme.grey9AA4B2
import com.example.moviesapp.ui.theme.white
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import com.example.moviesapp.ui.theme.greyE3E8EF
import com.example.moviesapp.ui.theme.textF16W400

@Composable
fun MoviesSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 1.dp,
                color = greyE3E8EF,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = white,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            decorationBox = { innerTextField ->

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        modifier = Modifier.height(24.dp)
                            .width(24.dp),
                        contentDescription = "Search",
                        tint = grey9AA4B2
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    if (value.isEmpty()) {
                        Text(
                            text = "Search movies",
                            color = grey9AA4B2,
                            style = textF16W400
                        )
                    }

                    innerTextField()
                }
            }
        )
    }
}
