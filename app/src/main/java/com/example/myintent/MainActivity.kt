package com.example.myintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val btnExplicit = findViewById<Button>(R.id.explicitIntentBtn)
        val btnImplicit = findViewById<Button>(R.id.implicitIntentBtn)


        btnExplicit.setOnClickListener {
            startActivity(Intent(this, ExplicitActivity::class.java))
        }

        btnImplicit.setOnClickListener {
            startActivity(Intent(this, ImplicitActivity::class.java))
        }
    }
}