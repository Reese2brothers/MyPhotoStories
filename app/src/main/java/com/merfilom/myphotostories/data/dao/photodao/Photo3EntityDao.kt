package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Photo3EntityDao {
    @Query("SELECT * FROM photo3entity")
    fun getAll(): Flow<List<Photo3Entity>>
    @Insert
    suspend fun insertPhoto(photo3Entity: Photo3Entity)
    @Delete
    suspend fun deletePhoto(photo3Entity: Photo3Entity)

}