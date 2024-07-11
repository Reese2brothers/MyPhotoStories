package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.domain.models.photomodels.Story2
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory2Repository
import kotlinx.coroutines.flow.Flow

class PhotoStory2RepositoryImpl : PhotoStory2Repository {
    override fun getAll(): Flow<List<Story2>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertStory2(story2: Story2) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStory2(story2: Story2) {
        TODO("Not yet implemented")
    }
}