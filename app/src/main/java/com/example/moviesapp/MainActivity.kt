package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.navigation.NavRoutes
import com.example.moviesapp.ui.screens.MovieDetailsScreen
import com.example.moviesapp.ui.screens.MoviesListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController, startDestination = NavRoutes.moviesListScreen, builder = {
                    composable(NavRoutes.moviesListScreen) {
                        MoviesListScreen(navController)
                    }
                    composable(NavRoutes.movieDetailsScreen) {
                        MovieDetailsScreen(navController)
                    }
                }
            )
        }
    }
}
