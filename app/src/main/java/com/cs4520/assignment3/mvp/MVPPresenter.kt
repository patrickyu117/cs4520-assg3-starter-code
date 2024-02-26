package com.cs4520.assignment3.mvp

import com.cs4520.assignment3.CalculatorModel

class MVPPresenter(private val model: CalculatorModel) : MVPInterface.Presenter {

    private lateinit var view: MVPInterface.View

    override fun setView(view: MVPInterface.View) {
        this.view = view
    }

    override fun onAddButtonClicked(input1: String, input2: String) {
        try {
            val result = model.add(input1.toDouble(), input2.toDouble())
            if (!result.isNaN()) {
                view.showResult("Result: $result")
                view.clearInputs()
            } else {
                view.showInvalidInputError()
            }
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
    }

    override fun onSubtractButtonClicked(input1: String, input2: String) {
        try {
            val result = model.subtract(input1.toDouble(), input2.toDouble())
            if (!result.isNaN()) {
                view.showResult("Result: $result")
                view.clearInputs()
            } else {
                view.showInvalidInputError()
            }
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
    }

    override fun onMultiplyButtonClicked(input1: String, input2: String) {
        try {
            val result = model.multiply(input1.toDouble(), input2.toDouble())
            if (!result.isNaN()) {
                view.showResult("Result: $result")
                view.clearInputs()
            } else {
                view.showInvalidInputError()
            }
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
    }

    override fun onDivideButtonClicked(input1: String, input2: String) {
        try {
            val result = model.divide(input1.toDouble(), input2.toDouble())
            if (!result.isNaN()) {
                view.showResult("Result: $result")
                view.clearInputs()
            } else {
                view.showInvalidInputError()
            }
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
    }
}