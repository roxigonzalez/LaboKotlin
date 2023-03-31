package com.gonzalez.labo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var fiveCentsButton:ImageView
    private lateinit var tenCentsButton:ImageView
    private lateinit var quarterCentsButton:ImageView
    private lateinit var dollarButton:ImageView
    private lateinit var moneyText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        listenEvents()
    }

    private fun bind() {
        fiveCentsButton = findViewById(R.id.five_cents)
        tenCentsButton = findViewById(R.id.ten_cents)
        quarterCentsButton = findViewById(R.id.quarter_cents)
        dollarButton = findViewById(R.id.one_dollar)
        moneyText = findViewById(R.id.amount_money_result)
    }

    private fun listenEvents() {
        var amountMoney:Double = 0.0

        fiveCentsButton.setOnClickListener { _ ->
            amountMoney += 0.05
            moneyText.text = "%.2f".format(amountMoney) //amountMoney.toString()

        }
        tenCentsButton.setOnClickListener { _ ->
            amountMoney += 0.10
            moneyText.text = "%.2f".format(amountMoney) //amountMoney.toString()

        }
        quarterCentsButton.setOnClickListener { _ ->
            amountMoney += 0.25
            moneyText.text = "%.2f".format(amountMoney) //amountMoney.toString()

        }
        dollarButton.setOnClickListener { _ ->
            amountMoney += 1.00
            moneyText.text = "%.2f".format(amountMoney) //amountMoney.toString()

        }

    }

}