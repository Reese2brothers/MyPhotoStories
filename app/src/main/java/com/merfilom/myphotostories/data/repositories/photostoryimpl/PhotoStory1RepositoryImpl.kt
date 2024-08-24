package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.Photo1ListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.Photo1Mapper
import com.merfilom.myphotostories.data.mappers.photostorylistmapper.PhotoStory1ListMapper
import com.merfilom.myphotostories.data.mappers.photostorymapper.PhotoStory1Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoStory1RepositoryImpl(private val story1EntityDao: Story1EntityDao) : PhotoStory1Repository{
    private val photoStory1Mapper: PhotoStory1Mapper = PhotoStory1Mapper()
    private val photoStory1ListMapper: PhotoStory1ListMapper = PhotoStory1ListMapper()
    override fun getAll(): Flow<List<Story1>> {
        return story1EntityDao.getAll().map { entities ->
            photoStory1ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        story1EntityDao.deleteAll()
    }

    override suspend fun insertStory1(story1: Story1) {
        val entity = photoStory1Mapper.mapToEntity(story1)
        story1EntityDao.insertStory(entity)
    }

    override suspend fun deleteStory1(story1: Story1) {
        val entity = photoStory1Mapper.mapToEntity(story1)
        story1EntityDao.deleteStory(entity)
    }

    override suspend fun deleteStoryById(storyId: Int) {
        story1EntityDao.deleteStoryById(storyId)
    }

    override suspend fun decrementAllStory1Ids() {
        story1EntityDao.decrementAllStory1Ids()
    }

    override suspend fun decrementIdsAfterDeleted(deletedId: Int) {
        story1EntityDao.decrementIdsAfterDeleted(deletedId)
    }

}