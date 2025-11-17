package com.example.moviesapp.network.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.models.TrendingMoviesResponse
import com.example.moviesapp.network.repository.MoviesRepository
import com.example.moviesapp.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _trendingMovies = MutableStateFlow<Response<TrendingMoviesResponse>>(Response.Loading())
    val trendingMovies: StateFlow<Response<TrendingMoviesResponse>> = _trendingMovies

    fun loadTrendingMovies() {
        viewModelScope.launch {
            _trendingMovies.value = Response.Loading()

            try {
                val result = repository.getTrendingMovies()
                Log.d("VIEWMODEL Result→", "$result")
                _trendingMovies.value = result
            } catch (e: Exception) {
                _trendingMovies.value = Response.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }
}
