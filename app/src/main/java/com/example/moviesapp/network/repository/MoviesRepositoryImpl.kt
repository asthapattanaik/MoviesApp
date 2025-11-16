package com.example.moviesapp.network.repository

import com.example.moviesapp.models.TrendingMoviesResponse
import com.example.moviesapp.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MoviesRepository {

    override suspend fun getTrendingMovies(): TrendingMoviesResponse {
        return apiService.getTrendingMovies()
    }
}

