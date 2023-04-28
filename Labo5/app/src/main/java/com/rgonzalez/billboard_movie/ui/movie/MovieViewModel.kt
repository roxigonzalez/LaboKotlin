package com.rgonzalez.billboard_movie.ui.movie

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.billboard_movie.data.model.moviesDatabase
import com.rgonzalez.billboard_movie.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

//    val movies: MutableList<MovieModel> = repository.getMovies()
    fun getMovies() = repository.getMovies()
    private val movies = getMovies()

    fun getMoviesAdapter(context: Context): MoviesAdapter {
        return MoviesAdapter((movies ?: emptyList()) as MutableList<Any>, context)
    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                //  dependency - then call with arguments
                val repository = MovieRepository(moviesDatabase)
                MovieViewModel(repository)
            }
        }
    }
}