package com.example.laboratorio05.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.MovieItemBinding
import com.example.laboratorio05.generated.callback.OnClickListener

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.movieTitleTextView.text = movie.name
        binding.movieQualificationTextView.text = movie.qualification

        binding.cardOne.setOnClickListener {
            clickListener(movie)
        }
    }
}