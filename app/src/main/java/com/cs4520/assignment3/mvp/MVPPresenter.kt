package com.cs4520.assignment3.mvp

import com.cs4520.assignment3.CalculatorModel

// Presenter class of the MVP responsible for handling user inputs,
// updating the UI, and interacting with the Model to perform business logic
class MVPPresenter(private val model: CalculatorModel) : MVPInterface.Presenter {

    private lateinit var view: MVPInterface.View

    // Set the view
    override fun setView(view: MVPInterface.View) {
        this.view = view
    }

    // Set the view for when add button is clicked
    override fun onAddButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to add the inputs
            val result = model.add(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise show an invalid input error
            if (!result.isNaN()) {
                view.showResult("Result: $result")
            } else {
                view.showInvalidInputError()
            }
        // Catch number format or illegal argument exception and display
        // an invalid input error
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
        view.clearInputs()
    }

    // Set the view for when subtract button is clicked
    override fun onSubtractButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to subtract the inputs
            val result = model.subtract(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise show an invalid input error
            if (!result.isNaN()) {
                view.showResult("Result: $result")
            } else {
                view.showInvalidInputError()
            }
        // Catch number format or illegal argument exception and display
        // an invalid input error
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
        view.clearInputs()
    }

    // Set the view for when multiply button is clicked
    override fun onMultiplyButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to multiply the inputs
            val result = model.multiply(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise show an invalid input error
            if (!result.isNaN()) {
                view.showResult("Result: $result")
            } else {
                view.showInvalidInputError()
            }
        // Catch number format or illegal argument exception and display
        // an invalid input error
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
        view.clearInputs()
    }

    // Set the view for when divide button is clicked
    override fun onDivideButtonClicked(input1: String, input2: String) {
        try {
            // Use Calculator Model to divide the inputs
            val result = model.divide(input1.toDouble(), input2.toDouble())
            // If the result is a number, display the result and clear the input
            // otherwise show an invalid input error
            if (!result.isNaN()) {
                view.showResult("Result: $result")
            } else {
                view.showInvalidInputError()
            }
        // Catch number format or illegal argument exception and display
        // an invalid input error
        } catch (e: NumberFormatException) {
            view.showInvalidInputError()
        } catch (e: IllegalArgumentException) {
            view.showInvalidInputError()
        }
        view.clearInputs()
    }
}