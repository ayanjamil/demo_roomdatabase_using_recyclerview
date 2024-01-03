package com.example.demo_roomdb_and_recyclerview
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_roomdb_and_recyclerview.databinding.ActivityClickHistoryBinding
import kotlinx.coroutines.launch

class clickHistory : AppCompatActivity() {
    private lateinit var imageList:ArrayList<model>
    private var binding: ActivityClickHistoryBinding? = null
    private lateinit var historyAdapter:historyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        var list: ArrayList<String>? = intent.getStringArrayListExtra("idList") ?: arrayListOf()
//        list = intent.getParcelableArrayListExtra<String>("idList") ?: arrayListOf()
//        imageList = intent.getParcelableArrayListExtra<model>("clickedImageList") ?: arrayListOf()
        // importing passed out value of clickedImageList from amin and storing it in local variable imagelist

        val dao = (application as DemoApp).db.idDao()
        getAllCompletedDates(dao)

//
//        binding?.rvidhistory?.layoutManager = LinearLayoutManager(this)
//        historyAdapter = historyAdapter(list)
//        binding?.rvidhistory?.adapter = historyAdapter
    }

    private fun getAllCompletedDates(idDao: idDao) {
        lifecycleScope.launch {
            idDao.fetchALlDates().collect { allCompletedDatesList->
                // TODO(Step 3 :here the dates which were printed in log.
                //  We will pass that list to the adapter class which we have created and bind it to the recycler view.)
                // START
                if (allCompletedDatesList.isNotEmpty()) {

                    // Creates a vertical Layout Manager
                    binding?.rvidhistory?.layoutManager = LinearLayoutManager(this@clickHistory)

                    // History adapter is initialized and the list is passed in the param.
                    val dates = ArrayList<String>()
                    for (id in allCompletedDatesList){
                        dates.add(id.id)
                    }
                    val historyAdapter = historyAdapter(ArrayList(dates))

                    // Access the RecyclerView Adapter and load the data into it
                    binding?.rvidhistory?.adapter = historyAdapter
                }
                else {
                    Log.d("history_empty","History empty")
                }
                // END
            }
        }

    }

}


