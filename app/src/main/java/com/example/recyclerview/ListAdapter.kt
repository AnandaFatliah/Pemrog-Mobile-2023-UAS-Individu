package com.example.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val videolist: List<video>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    // Kelas untuk menyimpan referensi elemen UI pada setiap item daftar
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambar: ImageView = itemView.findViewById(R.id.img_view)
        val judulvideo: TextView = itemView.findViewById(R.id.tv_judul_video)
        val description: TextView = itemView.findViewById(R.id.tv_description)
    }

    // Membuat ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        // Membuat tata letak item daftar dengan menggunakan LayoutInflater
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ListViewHolder(itemView)
    }

    // Menetapkan nilai untuk elemen UI pada setiap item daftar
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        // Mendapatkan data dari list sesuai dengan posisi item
        val (gambar, judul, description) = videolist[position]

        // Menetapkan nilai data ke elemen UI pada ViewHolder
        holder.gambar.setImageResource(gambar)
        holder.judulvideo.text = judul
        holder.description.text = description

        // Menangani klik item untuk membuka DetailActivity dengan data yang sesuai
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("shadow", videolist[holder.adapterPosition])
            holder.itemView.context.startActivities(arrayOf(intentDetail))
        }
    }

    // Mendapatkan jumlah total item dalam daftar
    override fun getItemCount(): Int = videolist.size
}
