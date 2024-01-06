package com.example.demo_roomdb_and_recyclerview
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_roomdb_and_recyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var imageList:ArrayList<model>
    private lateinit var clickedimageList:ArrayList<model>
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
        // and here the adapter setting ends
        ImageAdapter.onItemClick={
            clickedimageList.add(it) // putting this clicked item into clickeimageList variable
            var new :model = clickedimageList[clickedimageList.lastIndex] // for seeing the last objects id
            var id = new.id
            Log.d("id_last",id)

            val dao = (application as DemoApp).db.idDao() //definig the dao object
            addDateToDatabase(dao,id)//adding the id to db via function
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
    fun populateRecyclerview(){
        imageList= Constants.imageList()
    }

    private fun addDateToDatabase(idDao: idDao,id:String) {

        lifecycleScope.launch {
            idDao.insert(idEntity(id)) // uisng .insert defined in idDao interface
        }
    }
}