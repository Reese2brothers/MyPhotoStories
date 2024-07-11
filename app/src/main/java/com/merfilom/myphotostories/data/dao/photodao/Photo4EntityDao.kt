package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Photo4EntityDao {
    @Query("SELECT * FROM photo4entity")
    fun getAll(): Flow<List<Photo4Entity>>
    @Insert
    suspend fun insertPhoto(photo4Entity: Photo4Entity)
    @Delete
    suspend fun deletePhoto(photo4Entity: Photo4Entity)

}