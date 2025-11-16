package com.example.moviesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.ui.components.MoviePoster
import com.example.moviesapp.ui.theme.black
import com.example.moviesapp.ui.theme.grey9AA4B2
import com.example.moviesapp.ui.theme.textF16W400
import com.example.moviesapp.ui.theme.textF24W500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = grey9AA4B2
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp)
        ) {

            MoviePoster(
                imageUrl = "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
                height = 360.dp,
                width = 360.dp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Interstellar",
                style = textF24W500.copy(color = black)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "During World War II, Lt. Gen. Leslie Groves Jr. appoints physicist J. Robert Oppenheimer",
                style = textF16W400.copy(color = black)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
