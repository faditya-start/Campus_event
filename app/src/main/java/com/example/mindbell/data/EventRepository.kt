package com.example.mindbell.data

import com.example.mindbell.model.EventItem
import com.example.mindbell.R

object EventRepository {
    private val events = listOf(
        EventItem(
            1,
            "Seminar Teknologi Nasional",
            "Himpunan Mahasiswa",
            "12 Oktober 2026",
            "Gedung Serbaguna",
            "Seminar mengenai masa depan AI dan teknologi masa kini.",
            R.drawable.tech_post,
            "Seminar"
        ),
        EventItem(
            2,
            "Lomba Mobile Legends",
            "UKM E-Sport",
            "15 Oktober 2026",
            "Kantin Kampus",
            "Turnamen bergengsi antar fakultas dengan total hadiah jutaan rupiah.",
            R.drawable.campus_event,
            "Lomba"
        ),
        EventItem(
            3,
            "Workshop UI/UX Design",
            "Lab Komputer",
            "20 Oktober 2026",
            "Ruang 302",
            "Belajar Figma dasar hingga mahir bersama pakar industri.",
            R.drawable.tech_post,
            "Workshop"
        ),
        EventItem(
            4,
            "Seminar Kewirausahaan",
            "BEM Universitas",
            "25 Oktober 2026",
            "Aula Utama",
            "Strategi membangun startup mahasiswa dari nol hingga sukses.",
            R.drawable.campus_event,
            "Seminar"
        ),
        EventItem(
            5,
            "Pekan Olahraga Kampus",
            "UKM Olahraga",
            "10 November 2026",
            "Stadion Utama",
            "Kompetisi olahraga tahunan yang memperlombakan berbagai cabang olahraga menarik. Tunjukkan semangat juangmu!",
            R.drawable.sport_event,
            "Lomba"
        )
    )

    fun getEvents(): List<EventItem> {
        return events
    }

    fun getEventById(id: Int): EventItem? {
        return events.find { it.id == id }
    }
}
