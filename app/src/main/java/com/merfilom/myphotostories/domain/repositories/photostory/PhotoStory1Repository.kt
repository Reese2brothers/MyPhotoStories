package com.merfilom.myphotostories.domain.repositories.photostory

import com.merfilom.myphotostories.domain.models.photomodels.Story1
import kotlinx.coroutines.flow.Flow

interface PhotoStory1Repository {
    fun getAll() : Flow<List<Story1>>

    suspend fun deleteAll()

    suspend fun insertStory1(story1: Story1)

    suspend fun deleteStory1(story1: Story1)
    suspend fun deleteStoryById(storyId: String)
    suspend fun decrementAllStory1Ids()
    suspend fun decrementIdsAfterDeleted(deletedId: String)

}