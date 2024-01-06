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
    private var binding: ActivityClickHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val dao = (application as DemoApp).db.idDao() // initializing the dao
        getAllCompletedDates(dao)// fun for showing all data in db
    }

    private fun getAllCompletedDates(idDao: idDao) {
        lifecycleScope.launch {
            idDao.fetchALlDates().collect { allCompletedDatesList->
                if (allCompletedDatesList.isNotEmpty()) {
                    // if there is any data in db then only initialize the recyclerview and put all the data of DB in recyclerview
                    binding?.rvidhistory?.layoutManager = LinearLayoutManager(this@clickHistory)
                    val ids = ArrayList<String>()
                    for (id in allCompletedDatesList){
                        ids.add(id.id)
                        // initiating a loop which adds all data of dp in recylerview
                    }
                    val historyAdapter = historyAdapter(ArrayList(ids))// array list ie ids
                    binding?.rvidhistory?.adapter = historyAdapter
                }
                else {
                    Log.d("history_empty","History empty")
                }
            }
        }

    }

}


