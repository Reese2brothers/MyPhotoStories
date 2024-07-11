package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Photo2EntityDao {
    @Query("SELECT * FROM photo2entity")
    fun getAll(): Flow<List<Photo2Entity>>
    @Insert
    suspend fun insertPhoto(photo2Entity: Photo2Entity)
    @Delete
    suspend fun deletePhoto(photo2Entity: Photo2Entity)

}