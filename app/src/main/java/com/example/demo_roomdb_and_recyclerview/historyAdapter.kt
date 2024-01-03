package com.example.demo_roomdb_and_recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_roomdb_and_recyclerview.databinding.ItemHistoryRowBinding

//class historyAdapter(private val clickedimageList: ArrayList<model>) :
//    RecyclerView.Adapter<historyAdapter.historyViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): historyViewHolder {
//        val view = LayoutInflater.from(parent.context).
//        inflate(R.layout.items_row_history,parent,false)
//        return historyViewHolder(view)
//    }
//    override fun onBindViewHolder(holder: historyViewHolder, position: Int) {
//        val event = clickedimageList[position]
//        holder.image.setImageResource(event.eventImage)
//        holder.id.text=event.id
//    }
//    override fun getItemCount(): Int {
//        return clickedimageList.size
//    }
//    class historyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
//        val image:ImageView = itemView.findViewById(R.id.iv_history)
//        val id:TextView= itemView.findViewById(R.id.id_history)
//    }
//}

class historyAdapter(private val items: ArrayList<String>?) :
    RecyclerView.Adapter<historyAdapter.ViewHolder>() {

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val date: String = items!!.get(position)

        holder.tvPosition.text = (position + 1).toString()
        holder.tvItem.text = date

        // Updating the background color according to the odd/even positions in list.
        if (position % 2 == 0) {
            holder.llHistoryItemMain.setBackgroundColor(
                Color.parseColor("#EBEBEB")
            )
        } else {
            holder.llHistoryItemMain.setBackgroundColor(
                Color.parseColor("#FFFFFF")
            )
        }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items!!.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(binding: ItemHistoryRowBinding) : RecyclerView.ViewHolder(binding.root) {
        // Holds the TextView that will add each item to
        val llHistoryItemMain = binding.llHistoryItemMain
        val tvItem = binding.id
        val tvPosition = binding.tvPosition
    }
}
