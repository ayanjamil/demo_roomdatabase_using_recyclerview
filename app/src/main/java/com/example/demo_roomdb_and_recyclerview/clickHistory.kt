package com.example.demo_roomdb_and_recyclerview
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_roomdb_and_recyclerview.databinding.ActivityClickHistoryBinding
class clickHistory : AppCompatActivity() {
    private lateinit var imageList:ArrayList<model>
    private var binding: ActivityClickHistoryBinding? = null
    private lateinit var historyAdapter:historyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        imageList = intent.getParcelableArrayListExtra<model>("clickedImageList") ?: arrayListOf()
        // importing passed out value of clickedImageList from amin and storing it in local variable imagelist
        binding?.rvHistorylistofimages?.layoutManager = LinearLayoutManager(this)
        historyAdapter = historyAdapter(imageList)
        binding?.rvHistorylistofimages?.adapter = historyAdapter
    }

}


