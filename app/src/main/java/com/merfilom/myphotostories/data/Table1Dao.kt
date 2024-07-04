package com.merfilom.myphotostories.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Table1Dao {
    @Query("SELECT * FROM table1entity")
    fun getAll(): List<Table1Entity>

    @Insert
    suspend fun insertTable1(table1Entity: Table1Entity)

    @Delete
    suspend fun deleteTable1(table1Entity: Table1Entity)
}