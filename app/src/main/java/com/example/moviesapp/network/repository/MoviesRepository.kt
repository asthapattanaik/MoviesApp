package com.example.moviesapp.network.repository

import com.example.moviesapp.models.TrendingMoviesResponse
import com.example.moviesapp.network.ApiService
import com.example.moviesapp.utils.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getTrendingMovies(): Response<TrendingMoviesResponse> {
        return try {
            val configuration = apiService.getImageConfiguration()
            val baseUrl = configuration.images.secureBaseUrl
            val posterSize = configuration.images.posterSizes.getOrNull(4) ?: "w500" // w500 as default

            val response = apiService.getTrendingMovies()

            val moviesWithFullPoster = response.results.map { movie ->
                movie.copy(
                    poster_path = movie.poster_path?.let { "$baseUrl$posterSize$it" }
                )
            }

            val responseWithFullPoster = response.copy(results = moviesWithFullPoster)

            Response.Success(responseWithFullPoster)

        } catch (e: Exception) {
            println("API ERROR : ${e.message}")
            Response.Error("Failed to load trending movies: ${e.message}")
        }
    }
}
