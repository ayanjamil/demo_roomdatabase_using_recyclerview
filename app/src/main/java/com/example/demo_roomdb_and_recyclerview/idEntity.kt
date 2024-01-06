package com.example.demo_roomdb_and_recyclerview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class idEntity(
    @PrimaryKey
    val id :String)
//to fix
// problem is that when the same image is clicked the next time it crasehse
// solution is to clear the cashe and then click to see history
// so i have to make every click somehow uniques