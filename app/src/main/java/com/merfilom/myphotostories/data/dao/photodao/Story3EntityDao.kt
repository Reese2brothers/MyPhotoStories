package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Story3Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Story3EntityDao {
    @Query("SELECT * FROM story3entity")
    fun getAll(): Flow<List<Story3Entity>>
    @Query("DELETE FROM story3entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertStory(story3Entity: Story3Entity)
    @Delete
    suspend fun deleteStory(story3Entity: Story3Entity)

}