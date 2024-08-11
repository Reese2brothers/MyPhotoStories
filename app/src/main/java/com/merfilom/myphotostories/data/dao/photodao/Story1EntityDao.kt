package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Story1Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Story1EntityDao {
    @Query("SELECT * FROM story1entity")
    fun getAll(): Flow<List<Story1Entity>>

    @Query("DELETE FROM story1entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertStory(story1Entity: Story1Entity)
    @Delete
    suspend fun deleteStory(story1Entity: Story1Entity)

}