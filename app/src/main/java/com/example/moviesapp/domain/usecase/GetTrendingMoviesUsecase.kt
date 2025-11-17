package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.local.MovieEntity
import com.example.moviesapp.models.TrendingMoviesResponse
import com.example.moviesapp.network.repository.MoviesRepository
import com.example.moviesapp.utils.Response
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUsecase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(): Flow<Response<List<MovieEntity>>> {
        return repository.getTrendingMovies()
    }
}


