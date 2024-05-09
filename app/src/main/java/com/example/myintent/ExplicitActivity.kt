package com.example.myintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explicit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.explicit)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNama = findViewById<EditText>(R.id.namaEditText)
        val editNIM = findViewById<EditText>(R.id.nimEditText)
        val editKelas = findViewById<EditText>(R.id.kelasEditText)
        val btnSubmit = findViewById<Button>(R.id.submitButton)


        btnSubmit.setOnClickListener {


            if (editNama.text.toString().isEmpty()) {
                editNama.error = "Masukkan Nama!"
            } else if (editNIM.text.toString().isEmpty()) {
                editNIM.error = "Masukkan NIM"
            } else if (editKelas.text.toString().isEmpty()) {
                editKelas.error = "Masukkan Kelas!"
            } else if (!editNama.text.toString().matches("[a-zA-Z ]+".toRegex())) {
                editNama.error = "Masukan dalam Huruf!"
            } else if (!editNIM.text.toString().matches("[0-9]+".toRegex())) {
                editNIM.error = "Masukan dalam Angka!"
            } else if (!editKelas.text.toString().matches("[a-zA-Z ]+".toRegex())) {
                editKelas.error = "Masukan dalam Huruf!"
            } else {
                val sendDataIntent = Intent(this, DataActivity::class.java).apply {
                    putExtra("nama", editNama.text.toString())
                    putExtra("nim", editNIM.text.toString().toLong())
                    putExtra("kelas", editKelas.text.toString())
                }

                // Tambahkan data ke intent sebelum memulai DataActivity
                sendDataIntent.putExtra("fromMainActivity", true)
                sendDataIntent.putExtra("nama",
                    editNama.text.toString())
                sendDataIntent.putExtra("nim",
                    editNIM.text.toString())
                sendDataIntent.putExtra("kelas",
                    editKelas.text.toString())

                // Mulai SecondActivity
                startActivity(sendDataIntent)
                // Tutup FirstActivity
                finish()

}
        }

    }
}