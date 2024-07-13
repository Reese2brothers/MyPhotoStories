package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story5EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Story5
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory5Repository
import kotlinx.coroutines.flow.Flow

class PhotoStory5RepositoryImpl(story5EntityDao: Story5EntityDao) : PhotoStory5Repository {
    override fun getAll(): Flow<List<Story5>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertStory5(story5: Story5) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStory5(story5: Story5) {
        TODO("Not yet implemented")
    }
}