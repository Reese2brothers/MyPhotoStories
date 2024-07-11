package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Photo5EntityDao {
    @Query("SELECT * FROM photo5entity")
    fun getAll(): Flow<List<Photo5Entity>>
    @Insert
    suspend fun insertPhoto(photo5Entity: Photo5Entity)
    @Delete
    suspend fun deletePhoto(photo5Entity: Photo5Entity)

}