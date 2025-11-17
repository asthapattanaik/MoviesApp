# 🎬 MoviesApp

An Android application built with **Jetpack Compose**. 
The app fetches trending movies from TMDB, supports **search** and **offline caching**.

---
## 📹 Movies App Demo Recording

👉 **[Click to view app demo with sound on](https://drive.google.com/file/d/1OvRIJrGr9hLM8iFQYhLmsDurkOKsr2mr/view?usp=drive_link)**


## Features

### ✓ Trending Movies
- Fetches trending movies from TMDB API.
- Displays poster, title, and description.

### ✓ Offline Caching
- Uses Room Database to store movies locally
- When offline, the app loads movies from the local cache.

### ✓ Movie Search
- Search bar with placeholder.
- Real-time filtering based on movie title.
- Placeholder disappears when typing.
- Shows "No data found" state when search results are empty.

### ✓ Movie Image Loading
- Loads images using Coil. 
- Shimmer loading effect while images load. 
- Proper error placeholder with an icon if image loading fails.

### ✓ Architecture
- MVVM

### Dependency Injection
- Hilt

### Networking
- Retrofit
- OkHttp


