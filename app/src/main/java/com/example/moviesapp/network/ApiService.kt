package com.example.moviesapp.network

import com.example.moviesapp.models.ConfigurationResponse
import com.example.moviesapp.models.TrendingMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String = "week",
        @Query("language") language: String = "en-US"
    ): TrendingMoviesResponse

    @GET("configuration")
    suspend fun getImageConfiguration() : ConfigurationResponse
}

