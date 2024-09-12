package com.example.temperaturas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val inputValue: EditText = findViewById(R.id.inputValue)
        val radioCelsius: RadioButton = findViewById(R.id.radioCelsius)
        val radioFahrenheit: RadioButton = findViewById(R.id.radioFahrenheit)
        val radioKelvin: RadioButton = findViewById(R.id.radioKelvin)
        val resultCelsius: TextView = findViewById(R.id.resultCelsius)
        val resultFahrenheit: TextView = findViewById(R.id.resultFahrenheit)
        val resultKelvin: TextView = findViewById(R.id.resultKelvin)
        val convertButton: Button = findViewById(R.id.convertButton)

        convertButton.setOnClickListener {
            val value = inputValue.text.toString()
            if (value.isEmpty()) {
                resultCelsius.text = "Error"
                resultFahrenheit.text = "Error"
                resultKelvin.text = "Error"
            } else {
                val tempValue = value.toDouble()
                if (radioCelsius.isChecked) {
                    // Convertir desde Celsius
                    resultCelsius.text = "$tempValue °C"
                    resultFahrenheit.text = "${celsiusToFahrenheit(tempValue)} °F"
                    resultKelvin.text = "${celsiusToKelvin(tempValue)} K"
                } else if (radioFahrenheit.isChecked) {
                    // Convertir desde Fahrenheit
                    resultCelsius.text = "${fahrenheitToCelsius(tempValue)} °C"
                    resultFahrenheit.text = "$tempValue °F"
                    resultKelvin.text = "${fahrenheitToKelvin(tempValue)} K"
                } else if (radioKelvin.isChecked) {
                    // Convertir desde Kelvin
                    resultCelsius.text = "${kelvinToCelsius(tempValue)} °C"
                    resultFahrenheit.text = "${kelvinToFahrenheit(tempValue)} °F"
                    resultKelvin.text = "$tempValue K"
                }
            }
        }
    }

    // Funciones de conversión
    private fun celsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9/5) + 32
    }

    private fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5/9
    }

    private fun fahrenheitToKelvin(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5/9 + 273.15
    }

    private fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }

    private fun kelvinToFahrenheit(kelvin: Double): Double {
        return (kelvin - 273.15) * 9/5 + 32
    }
}