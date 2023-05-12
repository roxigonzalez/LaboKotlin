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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rgonzalez.billboard_movie.repositories.MovieRepository
import com.rgonzalez.billboard_movie.ui.movie.MovieViewModel


class BillboardFragment : Fragment() {
    private val viewModel:MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var btnActionSend: FloatingActionButton
    private lateinit var movieCard: CardView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_billboard, container, false)
        recyclerView = view.findViewById(R.id.movies_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = viewModel.getMoviesAdapter(requireContext())
        recyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Movies", viewModel.getMovies().toString())

        btnActionSend = view.findViewById(R.id.addMovie)
        // todo: I need to reference the recycler view but I don't know how xd
        // apparently we need to do in the adapter - not here
        // for that reason the code below is commented
        // Ima refactor soon ;)

//        movieCard = recyclerView.findViewById(R.id.card_one)
//        movieCard.setOnClickListener{
//            it.findNavController().navigate(R.id.action_billboardFragment3_to_movieFragment)
//
//        }
        btnActionSend.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment3_to_newMovieFragment)
        }

    }
}