package com.rgonzalez.labo03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        var name = findViewById<TextView>(R.id.name_text)
        var email = findViewById<TextView>(R.id.email_text)
        var number = findViewById<TextView>(R.id.number_text)

//        val nameText = getString(MainActivity.NAME_TEXT)
//        val numberText = getString(MainActivity.NUMBER_TEXT)
//        val emailText = getString(MainActivity.EMAIL_TEXT)

        val nameTxt = intent.getStringExtra("NAME_TEXT")
        name.text = nameTxt

        val numberTxt = intent.getStringExtra("NUMBER_TEXT")
        number.text = numberTxt

        val emailTxt = intent.getStringExtra("EMAIL_TEXT")
        email.text = emailTxt

//                findViewById<TextView>(R.id.name_text).apply {
//                    text = nameText
//                }

//        findViewById<TextView>(R.id.number_text).apply {
//            text = numberText
//        }
//        findViewById<TextView>(R.id.email_text).apply {
//            text = emailText
//        }

        share()
    }

    fun share() {
        shareButton = findViewById(R.id.share_button)
        shareButton.setOnClickListener{
            val nameText = findViewById<TextView>(R.id.name_text).text
            val numberText =  findViewById<TextView>(R.id.number_text).text
            val emailText = findViewById<TextView>(R.id.email_text).text
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "NameL $nameText \n Email: $emailText \n Number: $numberText")
            startActivity(Intent.createChooser(shareIntent, "Share to:"))
        }
    }
}