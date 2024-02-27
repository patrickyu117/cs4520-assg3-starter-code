package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.databinding.FragmentHomeBinding

// Home screen fragment
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    // Inflates the home screen view
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflates the view
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Sets the MVP and MVVM buttons to navigate to their respective screens
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Makes the MVP button navigate to the MVP fragment
        binding.mvpButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mvpFragment)
        }
        // Makes the MVVM button navigate to the MVVM fragment
        binding.mvvmButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mvvmFragment)
        }
    }
}