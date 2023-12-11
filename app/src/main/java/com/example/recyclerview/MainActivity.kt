package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // Deklarasi variabel untuk RecyclerView
    private lateinit var recyclerView: RecyclerView

    // Mendeklarasikan ArrayList untuk menyimpan data video
    private val list = ArrayList<video>()

    private var isAscendingSort = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mendapatkan referensi ke RecyclerView dari layout
        recyclerView = findViewById(R.id.rv_video)

        // Mengatur bahwa RecyclerView memiliki ukuran yang tetap
        recyclerView.setHasFixedSize(true)

        // Mengisi ArrayList dengan data dari sumber daya
        list.addAll(getList())

        // Menampilkan daftar video menggunakan RecyclerView
        showRecyclerList()

        // Tombol untuk sorting judul
        val sortTitleButton: Button = findViewById(R.id.btn_sort_title)

        sortTitleButton.setOnClickListener {
            // Toggle antara ascending dan descending sort
            isAscendingSort = !isAscendingSort

            if (isAscendingSort) {
                list.sortBy { it.judul }
            } else {
                list.sortByDescending { it.judul }
            }

            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    // Mendapatkan data video dari sumber daya
    private fun getList(): ArrayList<video> {
        val gambar = resources.obtainTypedArray(R.array.data_gambar)
        val dataName = resources.getStringArray(R.array.judul_video)
        val dataDescription = resources.getStringArray(R.array.data_dekripsi)
        val videoId = resources.obtainTypedArray(R.array.video_id)
        val listvideo = ArrayList<video>()

        // Mengisi ArrayList dengan objek video
        for (i in dataName.indices) {
            val video = video(gambar.getResourceId(i, -1), dataName[i], dataDescription[i], videoId.getResourceId(i, -1))
            listvideo.add(video)
        }
        return listvideo
    }

    // Menampilkan daftar video menggunakan RecyclerView
    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listadapter = ListAdapter(list)
        recyclerView.adapter = listadapter
    }
}
