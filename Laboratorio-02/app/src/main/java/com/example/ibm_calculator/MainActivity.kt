package com.example.ibm_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var weightInputText: EditText
    private lateinit var heightInputText: EditText
    private lateinit var calculateIbmButton: Button
    private lateinit var resultIbm: TextView
    private lateinit var resultDescription: TextView
    private lateinit var resultDescriptionHealthy: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        listenEvent()
    }

    private fun bind() {
        weightInputText = findViewById(R.id.weight_input_text)
        heightInputText = findViewById(R.id.height_input_text)
        calculateIbmButton = findViewById(R.id.calculate_button)
        resultIbm = findViewById(R.id.result_ibm)
        resultDescription = findViewById(R.id.result_description)
        resultDescriptionHealthy = findViewById(R.id.result_description_healthy)
    }

    private fun listenEvent() {
        calculateIbmButton.setOnClickListener { _ ->
            val weight: Double = weightInputText.text.toString().toDouble()
            val height: Double = heightInputText.text.toString().toDouble()

            val result = weight/(height*height)
            resultIbm.text = "%.2f".format(result)
            resultDescriptionHealthy.visibility = View.VISIBLE
            if (result < 18.5) {
                resultDescription.text = getString(R.string.result_underweight)
                resultDescription.setTextColor(getColor(R.color.light_blue))
            }else if(result in 18.25..24.99) {
                resultDescription.text = getString(R.string.result_healthy)
                resultDescription.setTextColor(getColor(R.color.green))
            }else if (result in 25.0..29.99) {
                resultDescription.text = getString(R.string.result_overweight)
                resultDescription.setTextColor(getColor(R.color.medium_orange))
            }else if(result > 30) {
                resultDescription.text = getString(R.string.result_obese)
                resultDescription.setTextColor(getColor(R.color.dark_orange))
            }

        }
    }
}