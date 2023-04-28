package com.rgonzalez.billboard_movie

import android.os.Bundle
import android.text.Editable.Factory
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rgonzalez.billboard_movie.repositories.MovieRepository
import com.rgonzalez.billboard_movie.ui.movie.MovieViewModel


class BillboardFragment : Fragment() {
    private val viewModel:MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var btnActionSend: FloatingActionButton
    private lateinit var movieCard: CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Movies", viewModel.getMovies().toString())

        btnActionSend = view.findViewById(R.id.addMovie)
        movieCard = view.findViewById(R.id.card_one)
        movieCard.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment3_to_movieFragment)

        }
        btnActionSend.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment3_to_newMovieFragment)
        }

    }
}