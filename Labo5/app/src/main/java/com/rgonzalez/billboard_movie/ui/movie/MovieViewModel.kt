package com.rgonzalez.billboard_movie.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.billboard_movie.data.model.MovieModel
import com.rgonzalez.billboard_movie.data.model.moviesDatabase
import com.rgonzalez.billboard_movie.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

    fun getMovies() = repository.getMovies()

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