package com.example.tiptime

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.provider.FontsContractCompat.Columns
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var showUpCalculateResult = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // bindingの初期化とsetContentViewを行う
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!showUpCalculateResult) {
            binding.tipResult.setVisibility(View.INVISIBLE)
            binding.totalAmount.setVisibility(View.INVISIBLE)
        }



        binding.calculateButton.setOnClickListener {
//            Toast.makeText(applicationContext, "ボタンが押されました", Toast.LENGTH_SHORT)
//                .show()
            showUpCalculateResult = true


            // EditTextの値を取得
            val costInput = binding.costOfService.text.toString()

            // Radio Buttonの値を取得
            val tipPercentageID = binding.tipOptions.checkedRadioButtonId
            var tipPercentage = 0.0

            // otherの数値の取得
            var otherNumberID = binding.enterHere.text.toString()
//            if(otherNumberID)


            var otherNumber = otherNumberID.toDoubleOrNull() ?: 0.0
            var changeToDecimal = otherNumber / 100

            when (tipPercentageID) {
                R.id.option_twenty_percent -> tipPercentage = 0.20
                R.id.option_eighteen_percent -> tipPercentage = 0.18
                R.id.option_fifteen_percent -> tipPercentage = 0.15
                R.id.option_other_percent -> tipPercentage = changeToDecimal
            }
            var tip = 0.0
            var totalAmount = 0.0

            if (costInput.isNotEmpty()) {
                var cost = costInput.toDouble()
                tip = cost * tipPercentage
                totalAmount = cost + tip
            }

            val toggleButton = binding.roundUpSwitch.isChecked


            if (showUpCalculateResult) {
                binding.tipResult.setVisibility(View.VISIBLE)
                binding.totalAmount.setVisibility(View.VISIBLE)


//                val toggleButton = binding.roundUpSwitch.isChecked
                // ONのときの処理
                if (toggleButton) {
                    binding.tipResult.text = String.format("Tip Amount: $%d", tip.toInt())

                    binding.totalAmount.text =
                        String.format("Total Amount: $%d", totalAmount.toInt())


                    // OFFのときの処理
                } else {
                    binding.tipResult.text = String.format("Tip Amount: $%.2f", tip)

                    binding.totalAmount.text = String.format("Total Amount: $%.2f", totalAmount)
                }


            }
        }
    }


}
