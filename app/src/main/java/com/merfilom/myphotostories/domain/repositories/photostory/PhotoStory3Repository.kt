package com.merfilom.myphotostories.domain.repositories.photostory

import com.merfilom.myphotostories.domain.models.photomodels.Story3
import kotlinx.coroutines.flow.Flow

interface PhotoStory3Repository {
    fun getAll() : Flow<List<Story3>>

    suspend fun insertStory3(story3: Story3)

    suspend fun deleteStory3(story3: Story3)

}