package com.example.mindbell

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.mindbell.data.EventRepository

class EventListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)

        // Tombol Kembali
        findViewById<ImageView>(R.id.iv_back).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val listView = findViewById<ListView>(R.id.lv_events)
        
        // Mengambil data dinamis dari Repository
        val eventList = EventRepository.getEvents()
        
        // Menyiapkan Adapter
        val adapter = EventAdapter(this, eventList)
        listView.adapter = adapter

        // Navigasi (ID only): Kirim eventId untuk efisiensi memori
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedEvent = eventList[position]
            val intent = Intent(this, EventDetailActivity::class.java).apply {
                putExtra("EVENT_ID", selectedEvent.id)
            }
            startActivity(intent)
        }
    }
}
