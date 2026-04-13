package com.example.mindbell

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mindbell.data.EventRepository

class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        // Tombol Kembali
        findViewById<ImageView>(R.id.iv_back).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Detail Event: Menangkap ID dari Intent
        val eventId = intent.getIntExtra("EVENT_ID", -1)
        
        // Kueri ulang ke EventRepository menggunakan ID
        val event = EventRepository.getEventById(eventId)

        if (event != null) {
            // Update UI dengan data dari Repository
            findViewById<TextView>(R.id.tv_detail_title).text = event.namaEvent
            findViewById<TextView>(R.id.tv_detail_info).text = "${event.tanggal} • ${event.lokasi}"
            findViewById<ImageView>(R.id.iv_event_image).setImageResource(event.imageResId)
            
            // Set deskripsi (jika ada di layout)
            // findViewById<TextView>(R.id.tv_detail_description).text = event.deskripsi

            findViewById<Button>(R.id.btn_register).setOnClickListener {
                // Aksi Interaktif: Toast dengan pesan dinamis
                Toast.makeText(this, "Berhasil mendaftar ke ${event.namaEvent}", Toast.LENGTH_SHORT).show()

                // Kembali ke home setelah beberapa detik
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    finish()
                }, 2000)
            }
        } else {
            Toast.makeText(this, "Event tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
