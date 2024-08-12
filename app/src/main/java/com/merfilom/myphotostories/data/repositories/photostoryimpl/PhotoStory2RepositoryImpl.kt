package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story2EntityDao
import com.merfilom.myphotostories.data.mappers.photostorylistmapper.PhotoStory2ListMapper
import com.merfilom.myphotostories.data.mappers.photostorymapper.PhotoStory2Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Story2
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory2Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoStory2RepositoryImpl(private val story2EntityDao: Story2EntityDao) : PhotoStory2Repository {
    private val photoStory2Mapper: PhotoStory2Mapper = PhotoStory2Mapper()
    private val photoStory2ListMapper: PhotoStory2ListMapper = PhotoStory2ListMapper()
    override fun getAll(): Flow<List<Story2>> {
        return story2EntityDao.getAll().map { entities ->
            photoStory2ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        story2EntityDao.deleteAll()
    }

    override suspend fun insertStory2(story2: Story2) {
        val entity = photoStory2Mapper.mapToEntity(story2)
        story2EntityDao.insertStory(entity)
    }

    override suspend fun deleteStory2(story2: Story2) {
        val entity = photoStory2Mapper.mapToEntity(story2)
        story2EntityDao.deleteStory(entity)
    }
}