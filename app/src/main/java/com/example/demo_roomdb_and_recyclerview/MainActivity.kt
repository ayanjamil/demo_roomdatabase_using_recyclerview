package com.example.demo_roomdb_and_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_roomdb_and_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnHistory?.setOnClickListener {
            val intent = Intent(this, clickHistory::class.java)
            startActivity(intent)
        }


//        val imageList = listOf(R.drawable.image01, R.drawable.image02, R.drawable.image03)
        val imageList = mutableListOf<Int>()
        for (i in 1..15) {
            val imageName = "image" + String.format("%02d", i)
            val resId = resources.getIdentifier(imageName, "drawable", packageName)
            imageList.add(resId)
        }

        binding?.rvList?.adapter = ImageAdapter(imageList)
        binding?.rvList?.layoutManager = LinearLayoutManager(this)

    }
}