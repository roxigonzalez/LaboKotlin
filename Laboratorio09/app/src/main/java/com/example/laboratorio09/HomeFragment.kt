package com.example.laboratorio09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.corutinesdemo.R
import com.example.corutinesdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mainThreadButton: Button
    private lateinit var coroutinesButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainThreadButton = view.findViewById(R.id.main_thread_button)
        mainThreadButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment2_to_mainThreadFragment2)
        }

        coroutinesButton = view.findViewById(R.id.coroutines_button)
        coroutinesButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment2_to_coroutinesFragment2)
        }

    }
}