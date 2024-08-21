package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoEmptyEntityDao {
    @Query("SELECT * FROM photoEmptyentity")
    fun getAll(): Flow<List<PhotoEmptyEntity>>
    @Query("DELETE FROM photoEmptyentity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photoEmptyEntity: PhotoEmptyEntity)
    @Query("DELETE FROM photoEmptyentity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("INSERT INTO photo1entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto1()
    @Query("INSERT INTO photo2entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto2()
    @Query("INSERT INTO photo3entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto3()
    @Query("INSERT INTO photo4entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto4()
    @Query("INSERT INTO photo5entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto5()

}