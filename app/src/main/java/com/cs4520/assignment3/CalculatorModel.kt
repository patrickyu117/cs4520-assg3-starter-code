package com.cs4520.assignment3

class CalculatorModel {
    fun add(input1 : Double, input2 : Double) : Double {
        return input1 + input2
    }

    fun subtract(input1 : Double, input2 : Double) : Double  {
        return input1 - input2
    }

    fun multiply(input1 : Double, input2 : Double) : Double  {
        return input1 * input2
    }

    fun divide(input1 : Double, input2 : Double) : Double  {
        if (input2 != 0.0) {
            return input1 / input2
        } else {
            throw IllegalArgumentException("Cannot divide by 0")
        }
    }
}