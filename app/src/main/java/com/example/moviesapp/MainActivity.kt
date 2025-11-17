package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesapp.navigation.NavRoutes
import com.example.moviesapp.ui.screens.MovieDetailsScreen
import com.example.moviesapp.ui.screens.MoviesListScreen
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = NavRoutes.moviesListScreen
            ) {
                composable(NavRoutes.moviesListScreen) {
                    MoviesListScreen(navController)
                }

                composable(
                    route = NavRoutes.movieDetailsScreen,
                    arguments = listOf(
                        navArgument("imageUrl") { type = NavType.StringType },
                        navArgument("title") { type = NavType.StringType },
                        navArgument("description") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val imageUrl = URLDecoder.decode(
                        backStackEntry.arguments?.getString("imageUrl") ?: "",
                        StandardCharsets.UTF_8.toString()
                    )
                    val title = URLDecoder.decode(
                        backStackEntry.arguments?.getString("title") ?: "",
                        StandardCharsets.UTF_8.toString()
                    )
                    val description = URLDecoder.decode(
                        backStackEntry.arguments?.getString("description") ?: "",
                        StandardCharsets.UTF_8.toString()
                    )

                    MovieDetailsScreen(
                        navController = navController,
                        imageUrl = imageUrl,
                        title = title,
                        description = description
                    )
                }
            }
        }
    }
}
