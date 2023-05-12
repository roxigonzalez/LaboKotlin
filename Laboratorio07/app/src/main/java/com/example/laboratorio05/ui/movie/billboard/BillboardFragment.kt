package com.example.laboratorio05.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentBillboardBinding
import com.example.laboratorio05.ui.movie.MovieViewModel
import com.example.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentBillboardBinding
    private lateinit var btnCreateNewMovie: FloatingActionButton
    private lateinit var starWarsCv: CardView
    private lateinit var harryPotterCv: CardView
    private lateinit var recyclerViewAdapter: MovieRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        btnCreateNewMovie = view.findViewById(R.id.btnNavCreateNewMovie)
//        starWarsCv = view.findViewById(R.id.starWarsCardView)
//        harryPotterCv = view.findViewById(R.id.harryPotterCardView)

//        starWarsCv.setOnClickListener {
//            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
//        }
//
//        harryPotterCv.setOnClickListener {
//            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
//        }

        btnCreateNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

    }
    fun showSelectedIem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    fun displayMovies() {
        recyclerViewAdapter.setData(movieViewModel.getMovies())
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun setRecyclerView(view: View) {
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerViewAdapter = MovieRecyclerViewAdapter{ selectedMovie ->
            showSelectedIem(selectedMovie)
        }

        binding.moviesRecyclerView.adapter = recyclerViewAdapter
        displayMovies()
    }


}