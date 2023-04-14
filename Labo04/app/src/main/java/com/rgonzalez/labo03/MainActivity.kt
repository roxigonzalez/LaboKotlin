package com.rgonzalez.labo03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var numberInput: EditText
    private lateinit var saveButton: Button



    // data element
    private var nameText = ""
    private var numberText = ""
    private var emailText = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        saveListener()
    }

    private fun bind() {
        nameInput = findViewById(R.id.name_input)
        emailInput = findViewById(R.id.email_input)
        numberInput = findViewById(R.id.number_input)
        saveButton = findViewById(R.id.save_btn)
    }

    private fun saveListener() {
        saveButton.setOnClickListener {
            val nameTxtValue = nameInput.text.toString()
            val numberTxtValue = numberInput.text.toString()
            val emailTextValue = emailInput.text.toString()

            var confirmationIntent = Intent(this, ConfirmationActivity::class.java)
            confirmationIntent.putExtra("NAME_TEXT", nameTxtValue)
            confirmationIntent.putExtra("NUMBER_TEXT", numberTxtValue)
            confirmationIntent.putExtra("EMAIL_TEXT", emailTextValue)
            startActivity(confirmationIntent)

        }
    }

    companion object {
        const val NAME_TEXT = "NAME_TEXT"
        const val NUMBER_TEXT = "NUMBER_TEXT"
        const val EMAIL_TEXT = "EMAIL_TEXT"

    }
}