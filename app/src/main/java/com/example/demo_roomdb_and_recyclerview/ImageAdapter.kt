package com.example.demo_roomdb_and_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
class ImageAdapter(private val imageList: ArrayList<model>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    //basic recylerview format
    var onItemClick:((model)->Unit)?=null
    // defining lamda function of clickability of items inside recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.rows_images,parent,false)
        return ImageViewHolder(view)
        // nothing much to do here it is what it is this is how you do it without viewbinding
    }
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val event = imageList[position]
        holder.image.setImageResource(event.eventImage)
        //assigning the positions of each event in the recyclerview
        // the recycler views text = event which is a variale decleared locally which holds
        // the values of a instance of eventList which is passed in the recyclerview

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(event)// the lambda function we defined whose
            // return type is unit or void
        }
    }
    override fun getItemCount(): Int {
        return imageList.size
    }
    class ImageViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.image_row)
//        val heading: TextView =itemView.findViewById(R.id.headding_event01)
//        val loctimeDetails: TextView =itemView.findViewById(R.id.tv_loctimedetails)
        // loctimeDetails is for the recylerview use only
        //importing all the ids of the itemrow XML as that XML is an example of how each element
        // in the recyclerview should be
    }
    //can also use binding in the above block
}