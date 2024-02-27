package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.CalculatorModel

// ViewModel part of MVVM, responsible for managing the UI-related data
// and state
class MVVMViewModel() : ViewModel(), MVVMInterface.ViewModel {
    private val model = CalculatorModel()
    // Utilizing live data to store the result of the calculation
    private val _result = MutableLiveData<String?>()
    override val result: LiveData<String?> get() = _result

    // Set the result for the add button
    override fun onAddButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to add the inputs
            val resultValue = model.add(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise set the result to null
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()

            } else {
                _result.value = null
            }
        // Catch number format or illegal argument exception and set the result to null
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }

    // Set the result for the subtract button
    override fun onSubtractButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to subtract the inputs
            val resultValue = model.subtract(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise set the result to null
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()
            } else {
                _result.value = null
            }
        // Catch number format or illegal argument exception and set the result to null
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }

    // Set the result for the multiply button
    override fun onMultiplyButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to multiply the inputs
            val resultValue = model.multiply(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise set the result to null
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()
            } else {
                _result.value = null
            }
        // Catch number format or illegal argument exception and set the result to null
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }

    // Set the result for the divide button
    override fun onDivideButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to divide the inputs
            val resultValue = model.divide(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise set the result to null
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()
            } else {
                _result.value = null
            }
        // Catch number format or illegal argument exception and set the result to null
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }
}