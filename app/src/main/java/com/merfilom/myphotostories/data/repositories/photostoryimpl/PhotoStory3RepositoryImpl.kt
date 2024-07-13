package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story3EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Story3
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory3Repository
import kotlinx.coroutines.flow.Flow

class PhotoStory3RepositoryImpl(story3EntityDao: Story3EntityDao) : PhotoStory3Repository{
    override fun getAll(): Flow<List<Story3>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertStory3(story3: Story3) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStory3(story3: Story3) {
        TODO("Not yet implemented")
    }
}