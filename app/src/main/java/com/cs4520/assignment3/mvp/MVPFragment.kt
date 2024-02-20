package com.cs4520.assignment3.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.FragmentMvpBinding

class MVPFragment : Fragment(), MVPInterface.View {

    private lateinit var binding: FragmentMvpBinding
    private lateinit var presenter: MVPInterface.Presenter
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
    override fun showResult(result: String) {
        binding.result.text = result
    }

    override fun showInvalidInputError() {
        Toast.makeText(requireContext(), "Invalid input", Toast.LENGTH_SHORT).show()
    }

    override fun clearInputs() {
        binding.input1.text.clear()
        binding.input2.text.clear()
    }

}