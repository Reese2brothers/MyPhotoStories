package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import kotlinx.coroutines.flow.Flow


@Dao
interface Photo1EntityDao {
    @Query("SELECT * FROM photo1entity")
    fun getAll(): Flow<List<Photo1Entity>>
    @Query("DELETE FROM photo1entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo1Entity: Photo1Entity)
    @Query("DELETE FROM photo1entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

}