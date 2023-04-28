package com.rgonzalez.billboard_movie.ui.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.billboard_movie.R
import com.rgonzalez.billboard_movie.data.model.MovieModel

class MoviesAdapter(private val movies: MutableList<Any>, private val context: Context) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> () {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie as MovieModel)
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(itemView: View, context: Context): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieModel) {
            itemView.findViewById<TextView>(R.id.movie_title_text_view).text = movie.name
            itemView.findViewById<TextView>(R.id.movie_qualification_text_view).text = movie.qualification
            val resId = context.resources.getIdentifier(movie.imgName, "drawable", context.packageName)
            itemView.findViewById<ImageView>(R.id.imageView).setImageResource(resId)

        }
    }
}