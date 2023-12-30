package com.example.demo_roomdb_and_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class historyAdapter(private val clickedimageList: ArrayList<model>) :
    RecyclerView.Adapter<historyAdapter.historyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): historyViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.items_row_history,parent,false)
        return historyViewHolder(view)
    }
    override fun onBindViewHolder(holder: historyViewHolder, position: Int) {
        val event = clickedimageList[position]
        holder.image.setImageResource(event.eventImage)
        holder.id.text=event.id
    }
    override fun getItemCount(): Int {
        return clickedimageList.size
    }
    class historyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.iv_history)
        val id:TextView= itemView.findViewById(R.id.id_history)
    }
}