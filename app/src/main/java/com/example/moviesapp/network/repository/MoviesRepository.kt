package com.example.moviesapp.network.repository

import com.example.moviesapp.data.local.MovieDao
import com.example.moviesapp.data.local.MovieEntity
import com.example.moviesapp.network.ApiService
import com.example.moviesapp.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val apiService: ApiService,
    private val movieDao: MovieDao
) {

    fun getTrendingMovies(): Flow<Response<List<MovieEntity>>> = flow {
        emit(Response.Loading())

        try {
            val config = apiService.getImageConfiguration()
            val baseUrl = config.images.secureBaseUrl
            val posterSize = config.images.posterSizes.getOrNull(4) ?: "w500"

            val response = apiService.getTrendingMovies()

            val movies = response.results.map { dto ->
                MovieEntity(
                    id = dto.id,
                    title = dto.title,
                    overview = dto.overview,
                    posterPath = dto.poster_path?.let { "$baseUrl$posterSize$it" },
                    voteAverage = dto.vote_average,
                    releaseDate = dto.release_date
                )
            }

            movieDao.clearMovies()
            movieDao.insertMovies(movies)

            emit(Response.Success(movies))

        } catch (e: Exception) {
            val cachedMovies = movieDao.getAllMovies().first()
            if (cachedMovies.isNotEmpty()) {
                emit(Response.Success(cachedMovies))
            } else {
                emit(Response.Error("Failed: ${e.message}"))
            }
        }
    }
}
