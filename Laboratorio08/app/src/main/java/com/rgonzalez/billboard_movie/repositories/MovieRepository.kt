package com.rgonzalez.billboard_movie.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rgonzalez.billboard_movie.data.model.MovieModel

class MovieRepository(private var movies: MutableLiveData<MovieModel>) {
    fun getMovies() = movies;


//    fun addMovie(movie: MovieModel) = movies.add(movie)
}

