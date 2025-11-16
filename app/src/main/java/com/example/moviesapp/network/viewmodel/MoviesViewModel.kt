package com.example.moviesapp.network.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.models.TrendingMoviesResponse
import com.example.moviesapp.domain.usecase.GetTrendingMoviesUsecase
import com.example.moviesapp.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getTrendingMoviesUsecase: GetTrendingMoviesUsecase
) : ViewModel() {

    private val _state = MutableLiveData<Response<TrendingMoviesResponse>>()
    val state: LiveData<Response<TrendingMoviesResponse>> = _state

    init {
        fetchTrendingMovies()
    }

    private fun fetchTrendingMovies() {
        _state.value = Response.Loading()

        viewModelScope.launch {
            try {
                val response = getTrendingMoviesUsecase()
                _state.postValue(Response.Success(response))
            } catch (e: Exception) {
                _state.postValue(Response.Error(e.localizedMessage ?: "Something went wrong"))
            }
        }
    }
}



