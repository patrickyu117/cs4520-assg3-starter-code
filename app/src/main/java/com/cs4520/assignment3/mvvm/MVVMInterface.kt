package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData

interface MVVMInterface {
    interface View {
        fun showInvalidInputError()
        fun clearInputs()
    }

    interface ViewModel {
        val result: LiveData<String?>
        fun onAddButtonClicked(input1: String, input2: String)
        fun onSubtractButtonClicked(input1: String, input2: String)
        fun onMultiplyButtonClicked(input1: String, input2: String)
        fun onDivideButtonClicked(input1: String, input2: String)
    }
}