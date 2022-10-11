package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import ipca.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var onNumberPressed : ((View) -> Unit)? = {
        val buttonPressed = it as? Button
        binding.textViewDisplay.text = binding.textViewDisplay.text.toString() + buttonPressed?.text
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
    }

}