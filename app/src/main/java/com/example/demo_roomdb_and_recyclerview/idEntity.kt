package com.example.demo_roomdb_and_recyclerview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class idEntity(
    @PrimaryKey
    val id :String)
