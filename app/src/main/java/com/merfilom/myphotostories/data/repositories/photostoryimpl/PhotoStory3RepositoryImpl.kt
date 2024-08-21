package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story3EntityDao
import com.merfilom.myphotostories.data.mappers.photostorylistmapper.PhotoStory3ListMapper
import com.merfilom.myphotostories.data.mappers.photostorymapper.PhotoStory3Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Story3
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory3Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoStory3RepositoryImpl(private val story3EntityDao: Story3EntityDao) :
    PhotoStory3Repository {
    private val photoStory3Mapper: PhotoStory3Mapper = PhotoStory3Mapper()
    private val photoStory3ListMapper: PhotoStory3ListMapper = PhotoStory3ListMapper()
    override fun getAll(): Flow<List<Story3>> {
        return story3EntityDao.getAll().map { entities ->
            photoStory3ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        story3EntityDao.deleteAll()
    }

    override suspend fun insertStory3(story3: Story3) {
        val entity = photoStory3Mapper.mapToEntity(story3)
        story3EntityDao.insertStory(entity)
    }

    override suspend fun deleteStory3(story3: Story3) {
        val entity = photoStory3Mapper.mapToEntity(story3)
        story3EntityDao.deleteStory(entity)
    }
}