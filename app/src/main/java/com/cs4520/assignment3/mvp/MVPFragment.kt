package com.cs4520.assignment3.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.CalculatorModel
import com.cs4520.assignment3.databinding.FragmentMvpBinding

// Class to handle the view part of the MVP
class MVPFragment : Fragment(), MVPInterface.View {

    private lateinit var binding: FragmentMvpBinding
    private lateinit var presenter: MVPInterface.Presenter

    // Creates the view and uses the presenter to set the view
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflates the view
        binding = FragmentMvpBinding.inflate(inflater, container, false)
        presenter = MVPPresenter(CalculatorModel())
        presenter.setView(this)
        return binding.root
    }

    // Uses the presenter to set the button functions
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set add button
        binding.addButton.setOnClickListener {
            presenter.onAddButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString()
            )
        }
        // Set subtract button
        binding.subButton.setOnClickListener {
            presenter.onSubtractButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString()
            )
        }
        // Set multiply button
        binding.multButton.setOnClickListener {
            presenter.onMultiplyButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString()
            )
        }
        // Set divide button
        binding.divButton.setOnClickListener {
            presenter.onDivideButtonClicked(
                binding.input1.text.toString(),
                binding.input2.text.toString()
            )
        }
    }

    // Show the result of the calculation on the screen
    override fun showResult(result: String) {
        binding.result.text = result
    }

    // Show a toast message for an invalid input
    override fun showInvalidInputError() {
        Toast.makeText(requireContext(), "Invalid Input", Toast.LENGTH_SHORT).show()
    }

    // Clear the input on the view
    override fun clearInputs() {
        binding.input1.text.clear()
        binding.input2.text.clear()
    }

}