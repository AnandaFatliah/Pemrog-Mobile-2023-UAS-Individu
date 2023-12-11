package com.example.recyclerview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class video_Activity : AppCompatActivity() {
    // Deklarasi variabel untuk VideoView
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        // Mendapatkan ID video dari intent
        val videoId = intent.getIntExtra("videoId", -1)

        // Mendapatkan referensi ke VideoView dari layout
        videoView = findViewById(R.id.vv_video)

        // Membuat path video dari resource menggunakan URI
        val videoPath = "android.resource://${packageName}/${videoId}"

        // Menetapkan URI video ke VideoView
        videoView.setVideoURI(Uri.parse(videoPath))

        // Menambahkan MediaController untuk mengontrol pemutaran video
        videoView.setMediaController(MediaController(this))

        // Memulai pemutaran video
        videoView.start()
    }
}
