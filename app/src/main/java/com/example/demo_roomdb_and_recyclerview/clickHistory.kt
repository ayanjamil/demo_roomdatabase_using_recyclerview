package com.example.demo_roomdb_and_recyclerview
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        binding?.rvHistorylistofimages?.layoutManager = LinearLayoutManager(this)
        populateRecyclerview()
        historyAdapter = historyAdapter(imageList)
        binding?.rvHistorylistofimages?.adapter = historyAdapter
    }
    fun populateRecyclerview(){
        imageList= ArrayList()

        imageList.add(
            model(
                R.drawable.image01,"01"
            )
        )
        imageList.add(
            model(
                R.drawable.image02,"02"
            ))
        imageList.add(
            model(
                R.drawable.image03,"03"
            ))
        imageList.add(
            model(
                R.drawable.image04,"04"
            ))
        imageList.add(
            model(
                R.drawable.image05,"05"
            ))
        imageList.add(
            model(
                R.drawable.image06,"06"
            ))
        imageList.add(
            model(
                R.drawable.image07,"07"
            ))
        imageList.add(
            model(
                R.drawable.image08,"08"
            ))
        imageList.add(
            model(
                R.drawable.image09,"09"
            ))
        imageList.add(
            model(
                R.drawable.image10,"10"
            ))
        imageList.add(
            model(
                R.drawable.image11,"11"
            ))
        imageList.add(
            model(
                R.drawable.image12,"12"
            ))
        imageList.add(
            model(
                R.drawable.image13,"13"
            ))
        imageList.add(
            model(
                R.drawable.image14,"14"
            ))
        imageList.add(
            model(
                R.drawable.image15,"15"
            ))


        //        imageList = ArrayList()
//        for (i in 1..16) {
//            val imageName = "image" + String.format("%02d", i)
//
//            val resId = resources.getIdentifier(imageName, "drawable", packageName)
//            val id = String.format("%02d", i).toString()
//            Log.d("loop_check","$resId")
//            imageList.add(model(resId,id))
//        }

    }
}


