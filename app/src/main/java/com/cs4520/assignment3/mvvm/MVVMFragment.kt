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

class MVVMFragment : Fragment(), MVVMInterface.View {

    private lateinit var binding: FragmentMvvmBinding
    private lateinit var viewModel: MVVMInterface.ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflates the view
        binding = FragmentMvvmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            viewModel.onAddButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        binding.subButton.setOnClickListener {
            viewModel.onSubtractButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        binding.divButton.setOnClickListener {
            viewModel.onDivideButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        binding.multButton.setOnClickListener {
            viewModel.onMultiplyButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString())
        }
        viewModel = ViewModelProvider(this)[MVVMViewModel::class.java]
        viewModel.result.observe(viewLifecycleOwner) { updated ->
           if (updated != null) {
               binding.result.text = "Result: $updated"
           } else {
               showInvalidInputError()
           }
        }
    }


    override fun showInvalidInputError() {
        Toast.makeText(requireContext(), "Invalid Input", Toast.LENGTH_SHORT).show()
    }

    override fun clearInputs() {
        binding.input1.text.clear()
        binding.input2.text.clear()
    }
}