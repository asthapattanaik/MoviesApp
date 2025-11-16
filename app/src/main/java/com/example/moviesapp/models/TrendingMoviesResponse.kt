package com.example.moviesapp.models

data class TrendingMoviesResponse(
    val page: Int,
    val results: List<MovieDto>
)
