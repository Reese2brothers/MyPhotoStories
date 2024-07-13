package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository
import kotlinx.coroutines.flow.Flow

class PhotoStory1RepositoryImpl(story1EntityDao: Story1EntityDao) : PhotoStory1Repository{
    override fun getAll(): Flow<List<Story1>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertStory1(story1: Story1) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStory1(story1: Story1) {
        TODO("Not yet implemented")
    }
}