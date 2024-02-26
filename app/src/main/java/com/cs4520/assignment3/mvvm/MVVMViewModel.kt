package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.CalculatorModel

class MVVMViewModel() : ViewModel(), MVVMInterface.ViewModel {
    private val model = CalculatorModel()
    private val _result = MutableLiveData<String?>()
    override val result: LiveData<String?> get() = _result

    override fun onAddButtonClicked(input1: String, input2: String) {
        try {
            val resultValue = model.add(input1.toDouble(), input2.toDouble())
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()
            } else {
                _result.value = null
            }
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }

    override fun onSubtractButtonClicked(input1: String, input2: String) {
        try {
            val resultValue = model.subtract(input1.toDouble(), input2.toDouble())
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()
            } else {
                _result.value = null
            }
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }

    override fun onMultiplyButtonClicked(input1: String, input2: String) {
        try {
            val resultValue = model.multiply(input1.toDouble(), input2.toDouble())
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()
            } else {
                _result.value = null
            }
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }

    override fun onDivideButtonClicked(input1: String, input2: String) {
        try {
            val resultValue = model.divide(input1.toDouble(), input2.toDouble())
            if (!resultValue.isNaN()) {
                _result.value = resultValue.toString()
            } else {
                _result.value = null
            }
        } catch (e: NumberFormatException) {
            _result.value = null
        } catch (e: IllegalArgumentException) {
            _result.value = null
        }
    }
}