package com.example.moviesapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviesapp.data.local.MovieEntity
import com.example.moviesapp.network.viewmodel.MoviesViewModel
import com.example.moviesapp.ui.components.MovieTile
import com.example.moviesapp.ui.components.MoviesSearchBar
import com.example.moviesapp.navigation.NavRoutes
import com.example.moviesapp.ui.components.NoMoviesFoundImage
import com.example.moviesapp.utils.Response


@Composable
fun MoviesListScreen(navController: NavController) {
    val viewModel: MoviesViewModel = hiltViewModel()

    var searchQuery by remember { mutableStateOf("") }

    val trendingMoviesResponse by viewModel.trendingMovies.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        MoviesSearchBar(
            value = searchQuery,
            onValueChange = { searchQuery = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        when (val response = trendingMoviesResponse) {
            is Response.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is Response.Success -> {
                val movies = response.data ?: emptyList()
                val filteredMovies = movies.filter {
                    it.title.contains(searchQuery, ignoreCase = true)
                }
                if (filteredMovies.isEmpty()){
                    NoMoviesFoundImage()
                }
                else{
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(4.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(filteredMovies) { movie ->
                            MovieTile(
                                imageUrl = movie.posterPath.toString(),
                                title = movie.title,
                                posterWidth = 172.dp,
                                posterHeight = 172.dp,
                                onClick = {
                                    navController.navigate(NavRoutes.movieDetailsScreenRoute(movie.posterPath.toString(), movie.title, movie.overview))
                                }
                            )
                        }
                    }
                }

            }

            is Response.Error -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Error: Something went wrong. Please try again later.")
                }
            }
        }
    }
}
