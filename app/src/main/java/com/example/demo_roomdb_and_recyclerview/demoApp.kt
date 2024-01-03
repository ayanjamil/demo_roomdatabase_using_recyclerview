package com.example.demo_roomdb_and_recyclerview

import android.app.Application

class demoApp:Application() {
    val db:idDatabase by lazy {
        idDatabase.getInstance(this)
    }
}