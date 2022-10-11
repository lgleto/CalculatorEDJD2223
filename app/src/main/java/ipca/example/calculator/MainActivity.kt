package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import ipca.example.calculator.databinding.ActivityMainBinding

enum class Operation(val op : String) {
    ADD("+") ,
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/")
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var operand = 0.0
    var operation : Operation = Operation.ADD

    var userInTheMiddleOfIntroduction = true

    private var onOperationPressed : ((View) -> Unit)? = {
        val buttonPressed = it as? Button
        operation = when (buttonPressed?.text){
            "+" -> Operation.ADD
            "-" -> Operation.SUBTRACT
            "*" -> Operation.MULTIPLY
            "/" -> Operation.DIVISION
            else -> Operation.ADD
        }
        operand = binding.textViewDisplay.text.toString().toDouble()
        userInTheMiddleOfIntroduction = false
    }

    private var onNumberPressed : ((View) -> Unit)? = {
        val buttonPressed = it as? Button
        val buttonText : String = buttonPressed?.text.toString()
        val displayText : String = binding.textViewDisplay.text.toString()

        if (userInTheMiddleOfIntroduction) {
            if (displayText == "0" ){
                if (buttonText == "."){
                    binding.textViewDisplay.text = displayText + buttonText
                }else{
                    binding.textViewDisplay.text = buttonText
                }
            }else{
                if (buttonText == "."){
                    if (!displayText.contains(".")){
                        binding.textViewDisplay.text = displayText + buttonText
                    }
                }else{
                    binding.textViewDisplay.text = displayText + buttonText
                }
            }
        }else{
            binding.textViewDisplay.text = buttonText
            userInTheMiddleOfIntroduction = true
        }



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(onNumberPressed)
        binding.button2.setOnClickListener(onNumberPressed)
        binding.button3.setOnClickListener(onNumberPressed)
        binding.button4.setOnClickListener(onNumberPressed)
        binding.button5.setOnClickListener(onNumberPressed)
        binding.button6.setOnClickListener(onNumberPressed)
        binding.button7.setOnClickListener(onNumberPressed)
        binding.button8.setOnClickListener(onNumberPressed)
        binding.button9.setOnClickListener(onNumberPressed)
        binding.button0.setOnClickListener(onNumberPressed)
        binding.buttonDot.setOnClickListener(onNumberPressed)

        binding.buttonPlus.setOnClickListener(onOperationPressed)
        binding.buttonDivide.setOnClickListener(onOperationPressed)
        binding.buttonMinus.setOnClickListener(onOperationPressed)
        binding.buttonMultiply.setOnClickListener(onOperationPressed)

        binding.buttonEqual.setOnClickListener {

            var result = when(operation){
                Operation.ADD -> operand + binding.textViewDisplay.text.toString().toDouble()
                Operation.SUBTRACT -> operand - binding.textViewDisplay.text.toString().toDouble()
                Operation.MULTIPLY -> operand * binding.textViewDisplay.text.toString().toDouble()
                Operation.DIVISION -> operand / binding.textViewDisplay.text.toString().toDouble()
            }
            binding.textViewDisplay.text = if ((result % 1.0) == 0.0){
                result.toInt().toString()
            }else{
                result.toString()
            }

        }
    }

}