package com.example.demo_roomdb_and_recyclerview

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface idDao {
    @Insert
    suspend fun insert(IdEntity: idEntity)

    @Query("Select * from idEntity")
    fun fetchALlDates(): Flow<List<idEntity>>

}