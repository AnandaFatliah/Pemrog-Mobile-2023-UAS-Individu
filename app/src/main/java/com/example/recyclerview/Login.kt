package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    // Deklarasi variabel untuk elemen UI
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        // Inisialisasi variabel dengan referensi ke elemen UI
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        // Menangani klik tombol login
        loginButton.setOnClickListener {
            // Mendapatkan nilai yang dimasukkan oleh pengguna
            val enteredUsername = username.text.toString()
            val enteredPassword = password.text.toString()

            // Contoh validasi sederhana
            if (enteredUsername == "Nada" && enteredPassword == "120404") {
                // Menampilkan pesan Toast untuk login berhasil
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                // Membuka MainActivity setelah login berhasil
                startActivity(Intent(this@Login, MainActivity::class.java))
            } else if (enteredUsername == "Nada" && enteredPassword != "120404") {
                // Menampilkan pesan Toast untuk password salah
                Toast.makeText(this, "Password Salah", Toast.LENGTH_SHORT).show()
            } else if (enteredUsername != "Nada" && enteredPassword == "120404") {
                // Menampilkan pesan Toast untuk username salah
                Toast.makeText(this, "Username Salah", Toast.LENGTH_SHORT).show()
            } else {
                // Menampilkan pesan Toast untuk login gagal
                Toast.makeText(this, "Harap Isi Semua Data!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
