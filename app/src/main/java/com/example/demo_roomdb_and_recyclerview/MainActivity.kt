package com.example.demo_roomdb_and_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_roomdb_and_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var imageList:ArrayList<model>
    private lateinit var ImageAdapter:ImageAdapter
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.rvList?.layoutManager = LinearLayoutManager(this)

        imageList = ArrayList()
        for (i in 1..16) {
            val imageName = "image" + String.format("%02d", i)
            val resId = resources.getIdentifier(imageName, "drawable", packageName)
            imageList.add(model(resId,i))
        }

//        imageList= ArrayList()
////        imageList.add(
//            eventImage(
//                com.example.demo_roomdb_and_recyclerview.R.drawable.image01,
//        ))
//        this is how to add manually
        ImageAdapter = ImageAdapter(imageList)
        // adapter instance is set to the recyclerview to inflate the items.
        binding?.rvList?.adapter = ImageAdapter
        // and here the adapter setting ends
        ImageAdapter.onItemClick={

            intent.putExtra("Image",it)

            Log.d("click","click in the main is getting registerd")
        }

        binding?.btnHistory?.setOnClickListener {
            val intent = Intent(this, clickHistory::class.java)
            startActivity(intent)
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}