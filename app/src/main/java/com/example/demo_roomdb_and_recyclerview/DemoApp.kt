package com.example.demo_roomdb_and_recyclerview

import android.app.Application

class DemoApp:Application() {
    val db by lazy {
        idDatabase.getInstance(this)
    }
}