package com.example.mindbell

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
    import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dashboard: Pindah ke EventListActivity menggunakan Intent
        findViewById<TextView>(R.id.tv_see_all).setOnClickListener {
            val intent = Intent(this, EventListActivity::class.java)
            startActivity(intent)
        }

        // Contoh klik pada Featured Card -> Pindah ke Detail dengan ID (untuk efisiensi memori)
        findViewById<CardView>(R.id.cv_featured_event).setOnClickListener {
            val intent = Intent(this, EventDetailActivity::class.java).apply {
                putExtra("EVENT_ID", 1) // Hanya mengirim Identifier unik
            }
            startActivity(intent)
        }

        // Tombol Notifikasi
        findViewById<ImageView>(R.id.iv_notification).setOnClickListener {
            Toast.makeText(this, "Tidak ada notifikasi baru", Toast.LENGTH_SHORT).show()
        }
    }
}
