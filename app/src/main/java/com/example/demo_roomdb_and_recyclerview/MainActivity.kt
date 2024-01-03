package com.example.demo_roomdb_and_recyclerview
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_roomdb_and_recyclerview.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var imageList:ArrayList<model>
    private lateinit var clickedimageList:ArrayList<model>
    private lateinit var list:ArrayList<String>
    private lateinit var ImageAdapter:ImageAdapter
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.rvList?.layoutManager = LinearLayoutManager(this)
        populateRecyclerview()
        ImageAdapter = ImageAdapter(imageList)
        // adapter instance is set to the recyclerview to inflate the items.
        binding?.rvList?.adapter = ImageAdapter
        clickedimageList= ArrayList()
        list= ArrayList()
        // and here the adapter setting ends
        ImageAdapter.onItemClick={
            clickedimageList.add(it) // putting this clicked item into clickeimageList variable
            var new :model = clickedimageList[clickedimageList.lastIndex] // for seeing the last objects id
            list.add(new.id)

            Log.d("clicked",clickedimageList.toString())
            Log.d("id_list",list.toString())
        }
        binding?.btnHistory?.setOnClickListener {
            val intent = Intent(this, clickHistory::class.java)
//            intent.putParcelableArrayListExtra("clickedImageList", clickedimageList)
            intent.putStringArrayListExtra("idList", list)
//            intent.putParcelableArrayListExtra("idList",list)

            // this is how you pass any value from one file to another using internt and put extra
            startActivity(intent)
            Log.d("final_clicked_list",clickedimageList.toString())
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
    fun populateRecyclerview(){
        imageList= Constants.imageList()
    }
}