package com.example.moviesapp.domain.usecase

import com.example.moviesapp.models.TrendingMoviesResponse
import com.example.moviesapp.network.repository.MoviesRepository
import com.example.moviesapp.utils.Response
import javax.inject.Inject

class GetTrendingMoviesUsecase @Inject constructor(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(): Response<TrendingMoviesResponse> {
        return repository.getTrendingMovies()
    }
}

