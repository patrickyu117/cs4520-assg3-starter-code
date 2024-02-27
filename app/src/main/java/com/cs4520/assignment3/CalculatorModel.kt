package com.cs4520.assignment3

// Calculator model that handles the calculation model
class CalculatorModel {
    // Adds 2 inputs
    fun add(input1 : Double, input2 : Double) : Double {
        return input1 + input2
    }

    // Subtracts 2 inputs
    fun subtract(input1 : Double, input2 : Double) : Double  {
        return input1 - input2
    }

    // Multiplies 2 inputs
    fun multiply(input1 : Double, input2 : Double) : Double  {
        return input1 * input2
    }

    // Divides 2 inputs, if dividing by 0 is attempted, throw an illegal argument exception
    fun divide(input1 : Double, input2 : Double) : Double  {
        if (input2 != 0.0) {
            return input1 / input2
        } else {
            throw IllegalArgumentException("Cannot divide by 0")
        }
    }
}