package com.example.q3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etUserMessage: EditText = findViewById(R.id.etUserMessage)
        val btnSendMsgToNextActivity1: Button = findViewById(R.id.btCalculations)
        btnSendMsgToNextActivity1.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", message)
            startActivity(intent)
        }
        val btnSendMsgToNextActivity2: Button = findViewById(R.id.btCountry)
        btnSendMsgToNextActivity2.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("key", message)
            startActivity(intent)
        }
    }
}