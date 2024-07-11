package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Story5Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Story5EntityDao {
    @Query("SELECT * FROM story5entity")
    fun getAll(): Flow<List<Story5Entity>>
    @Insert
    suspend fun insertStory(story5Entity: Story5Entity)
    @Delete
    suspend fun deleteStory(story5Entity: Story5Entity)

}