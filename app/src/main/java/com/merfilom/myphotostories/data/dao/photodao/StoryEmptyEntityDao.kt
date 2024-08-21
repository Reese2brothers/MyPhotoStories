package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.StoryEmptyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StoryEmptyEntityDao {
    @Query("SELECT * FROM storyEmptyentity")
    fun getAll(): Flow<List<StoryEmptyEntity>>

    @Query("DELETE FROM storyEmptyentity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertStory(storyEmptyEntity: StoryEmptyEntity)
    @Delete
    suspend fun deleteStory(storyEmptyEntity: StoryEmptyEntity)

}