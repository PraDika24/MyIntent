package com.example.myintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data)


        val namaTxt = findViewById<TextView>(R.id.nameTxt)
        val nimTxt = findViewById<TextView>(R.id.nimTxt)
        val kelasTxt = findViewById<TextView>(R.id.kelasTxt)
        val btnBack = findViewById<Button>(R.id.btnKembali)

        namaTxt.text = intent.getStringExtra("nama").toString()
        nimTxt.text = intent.getStringExtra("nim").toString()
        kelasTxt.text = intent.getStringExtra("kelas").toString()



        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

            finish()

        }




    }
}