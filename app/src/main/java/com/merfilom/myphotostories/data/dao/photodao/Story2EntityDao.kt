package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Story2Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Story2EntityDao {
    @Query("SELECT * FROM story2entity")
    fun getAll(): Flow<List<Story2Entity>>
    @Query("DELETE FROM story2entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertStory(story2Entity: Story2Entity)
    @Delete
    suspend fun deleteStory(story2Entity: Story2Entity)

}