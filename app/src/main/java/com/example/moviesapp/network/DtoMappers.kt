package com.example.moviesapp.network

import com.example.moviesapp.models.TrendingMoviesResponse
import com.example.moviesapp.network.dto.MovieDto

fun MovieDto.addImageBaseUrl(): MovieDto {
    val base = "https://image.tmdb.org/t/p/w500"

    return this.copy(
        poster_path = poster_path?.let { base + it },
    )
}
