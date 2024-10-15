package com.example.tiptime

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // bindingの初期化とsetContentViewを行う


        binding.calculateButton.setOnClickListener {
//                Toast.makeText(applicationContext, "ボタンが押されました", Toast.LENGTH_SHORT)
//                    .show()
            // EditTextの値を取得
            val costInput = binding.costOfService.text.toString()

            // Radio Buttonの値を取得
            val tipPercentageID = binding.tipOptions.checkedRadioButtonId
            var tipPercentage = 0.0

            when (tipPercentageID) {
                R.id.option_twenty_percent -> tipPercentage = 0.20
                R.id.option_eighteen_percent -> tipPercentage =0.18
                R.id.option_fifteen_percent -> tipPercentage =0.15
            }
            var tip = 0.0
            var totalAmount = 0.0

            if (costInput.isNotEmpty()) {
                var cost = costInput.toDouble()
                tip = cost * tipPercentage
                totalAmount = cost + tip
            }

            binding.tipResult.text = String.format("tip: $%.2f", tip)

            binding.totalAmount.text = String.format("total Amount: $%.2f", totalAmount)



        }

    }


}

