package com.cs4520.assignment3.mvp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.CalculatorModel

// MVP interface contract, for both view and presenter
interface MVPInterface {
    interface View {
        fun showResult(result: String)
        fun showInvalidInputError()
        fun clearInputs()
    }

    interface Presenter {
        fun setView(view: View)
        fun onAddButtonClicked(input1: String, input2: String)
        fun onSubtractButtonClicked(input1: String, input2: String)
        fun onMultiplyButtonClicked(input1: String, input2: String)
        fun onDivideButtonClicked(input1: String, input2: String)
    }


}