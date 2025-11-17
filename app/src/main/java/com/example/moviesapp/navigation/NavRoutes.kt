package com.example.moviesapp.navigation

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object NavRoutes {
    const val moviesListScreen = "moviesListScreen"
    const val movieDetailsScreen = "movieDetailsScreen/{imageUrl}/{title}/{description}"

    fun movieDetailsScreenRoute(imageUrl: String, title: String, description: String): String {
        val encodedImageUrl = URLEncoder.encode(imageUrl, StandardCharsets.UTF_8.toString())
        val encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
        val encodedDescription = URLEncoder.encode(description, StandardCharsets.UTF_8.toString())
        return "movieDetailsScreen/$encodedImageUrl/$encodedTitle/$encodedDescription"
    }
}
