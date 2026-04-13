package com.example.mindbell

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mindbell.model.EventItem

class EventAdapter(private val context: Context, private val eventList: List<EventItem>) : BaseAdapter() {

    override fun getCount(): Int = eventList.size

    override fun getItem(position: Int): Any = eventList[position]

    override fun getItemId(position: Int): Long = eventList[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_event, parent, false)
        
        val event = eventList[position]
        
        val ivImage = view.findViewById<ImageView>(R.id.iv_item_image)
        val tvName = view.findViewById<TextView>(R.id.tv_item_name)
        val tvOrganizer = view.findViewById<TextView>(R.id.tv_item_organizer)
        val tvLocation = view.findViewById<TextView>(R.id.tv_item_location)
        
        ivImage.setImageResource(event.imageResId)
        tvName.text = event.namaEvent
        tvOrganizer.text = event.penyelenggara
        tvLocation.text = event.lokasi
        
        return view
    }
}
