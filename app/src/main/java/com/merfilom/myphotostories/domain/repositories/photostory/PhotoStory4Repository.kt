package com.merfilom.myphotostories.domain.repositories.photostory

import com.merfilom.myphotostories.domain.models.photomodels.Story4
import kotlinx.coroutines.flow.Flow

interface PhotoStory4Repository {
    fun getAll() : Flow<List<Story4>>

    suspend fun deleteAll()

    suspend fun insertStory4(story4: Story4)

    suspend fun deleteStory4(story4: Story4)

}