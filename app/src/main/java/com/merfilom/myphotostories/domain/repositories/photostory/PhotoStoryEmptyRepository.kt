package com.merfilom.myphotostories.domain.repositories.photostory

import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty
import kotlinx.coroutines.flow.Flow

interface PhotoStoryEmptyRepository {
    fun getAll() : Flow<List<StoryEmpty>>

    suspend fun deleteAll()

    suspend fun insertStoryEmpty(storyEmpty: StoryEmpty)

    suspend fun deleteStoryEmpty(storyEmpty: StoryEmpty)

}