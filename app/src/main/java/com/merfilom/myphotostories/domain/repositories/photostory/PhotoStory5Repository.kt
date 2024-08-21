package com.merfilom.myphotostories.domain.repositories.photostory

import com.merfilom.myphotostories.domain.models.photomodels.Story5
import kotlinx.coroutines.flow.Flow

interface PhotoStory5Repository {
    fun getAll() : Flow<List<Story5>>

    suspend fun deleteAll()

    suspend fun insertStory5(story5: Story5)

    suspend fun deleteStory5(story5: Story5)

}