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
    @Query("DELETE FROM photo4entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo4Entity: Photo4Entity)
    @Query("DELETE FROM photo4entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("SELECT COUNT(*) FROM photo4entity")
    suspend fun getRowCount(): Int

}