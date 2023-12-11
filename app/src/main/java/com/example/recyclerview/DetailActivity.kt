package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Mendapatkan data yang dikirimkan melalui intent
        val receivedData = if (Build.VERSION.SDK_INT >= 33) {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<video>("shadow")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<video>("shadow")
        }

        // Mendapatkan referensi ke elemen UI pada layout
        val gambar: ImageView = findViewById(R.id.img_gambar)
        val judul: TextView = findViewById(R.id.tv_Judul)
        val description: TextView = findViewById(R.id.tv_description)
        val playButton: ImageView = findViewById(R.id.tombol_play)

        // Menampilkan data yang diterima ke dalam elemen UI
        if (receivedData != null) {
            gambar.setImageResource(receivedData.gambar)
            judul.text = receivedData.judul
            description.text = receivedData.data_deskripsi

            // Menangani klik tombol play untuk memulai aktivitas video
            playButton.setOnClickListener {
                val videoIntent = Intent(this, video_Activity::class.java)
                videoIntent.putExtra("videoId", receivedData.videoId)
                startActivity(videoIntent)
            }
        }

        // Mendapatkan referensi ke tombol logout dan menangani logout
        val btnLogoutDetail: Button = findViewById(R.id.btn_logout_detail)
        btnLogoutDetail.setOnClickListener {
            // Menangani logout, misalnya kembali ke LoginActivity
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}
