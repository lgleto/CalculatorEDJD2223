package ipca.example.calculator

enum class Operation(val op : String) {
    ADD("+") ,
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/")
}

class CalculatorBrain {

    var operand : Double = 0.0
    var operation : Operation? = null

    fun doOperation(op2 : Double) : Double? {
        var result = when(operation){
            Operation.ADD -> operand + op2
            Operation.SUBTRACT -> operand - op2
            Operation.MULTIPLY -> operand * op2
            Operation.DIVISION -> operand / op2
            else -> null
        }
        return result
    }
}