package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.domain.models.photomodels.Story4
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory4Repository
import kotlinx.coroutines.flow.Flow

class PhotoStory4RepositoryImpl : PhotoStory4Repository {
    override fun getAll(): Flow<List<Story4>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertStory4(story4: Story4) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStory4(story4: Story4) {
        TODO("Not yet implemented")
    }
}