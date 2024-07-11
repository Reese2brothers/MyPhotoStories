package com.merfilom.myphotostories.domain.repositories.photostory

import com.merfilom.myphotostories.domain.models.photomodels.Story2
import kotlinx.coroutines.flow.Flow

interface PhotoStory2Repository {
    fun getAll() : Flow<List<Story2>>

    suspend fun insertStory2(story2: Story2)

    suspend fun deleteStory2(story2: Story2)

}