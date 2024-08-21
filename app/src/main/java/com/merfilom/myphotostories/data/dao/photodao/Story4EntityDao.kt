package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Story4Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Story4EntityDao {
    @Query("SELECT * FROM story4entity")
    fun getAll(): Flow<List<Story4Entity>>
    @Query("DELETE FROM story4entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertStory(story4Entity: Story4Entity)
    @Delete
    suspend fun deleteStory(story4Entity: Story4Entity)

}