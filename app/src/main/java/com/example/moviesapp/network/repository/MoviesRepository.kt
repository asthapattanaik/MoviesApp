package com.example.moviesapp.network.repository

import com.example.moviesapp.models.TrendingMoviesResponse

interface MoviesRepository {
    suspend fun getTrendingMovies(): TrendingMoviesResponse
}
