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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        // bindingの初期化とsetContentViewを行う
        binding = ActivityInputDataBinding.inflate(layoutInflater)
            .apply { setContentView(this.root) }

        var ServiceCost = binding.editTextnumber.toString()

        findViewById<Button>(R.id.calculate_button)
            .setOnClickListener {
                Toast.makeText(applicationContext, "ボタンが押されました", Toast.LENGTH_SHORT).show()
            }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        }
    }
