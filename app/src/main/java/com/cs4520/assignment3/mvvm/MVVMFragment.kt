package com.cs4520.assignment3.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.databinding.FragmentMvvmBinding

// View part of the MVVM
class MVVMFragment : Fragment(), MVVMInterface.View {

    private lateinit var binding: FragmentMvvmBinding
    private lateinit var viewModel: MVVMInterface.ViewModel

    // Inflates the view
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflates the view
        binding = FragmentMvvmBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Calls the view model to handle what happens when a button is clicked
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set add button
        binding.addButton.setOnClickListener {
            viewModel.onAddButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        // Set subtract button
        binding.subButton.setOnClickListener {
            viewModel.onSubtractButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        // Set divide button
        binding.divButton.setOnClickListener {
            viewModel.onDivideButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        // Set multiply button
        binding.multButton.setOnClickListener {
            viewModel.onMultiplyButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        // Observe the result from the view model and display the result if
        // it is valid, i.e. not null, otherwise show an invalid input error
        viewModel = ViewModelProvider(this)[MVVMViewModel::class.java]
        viewModel.result.observe(viewLifecycleOwner) { updated ->
            clearInputs()
            if (updated != null) {
               binding.result.text = "Result: $updated"
           } else {
               showInvalidInputError()
           }
        }
    }

    // Shows a toast message for an invalid input
    override fun showInvalidInputError() {
        Toast.makeText(requireContext(), "Invalid Input", Toast.LENGTH_SHORT).show()
    }

    // Clears the input
    override fun clearInputs() {
        binding.input1.text.clear()
        binding.input2.text.clear()
    }
}