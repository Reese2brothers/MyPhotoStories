package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story4EntityDao
import com.merfilom.myphotostories.data.mappers.photostorylistmapper.PhotoStory4ListMapper
import com.merfilom.myphotostories.data.mappers.photostorymapper.PhotoStory4Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Story4
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory4Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoStory4RepositoryImpl(private val story4EntityDao: Story4EntityDao) :
    PhotoStory4Repository {
    private val photoStory4Mapper: PhotoStory4Mapper = PhotoStory4Mapper()
    private val photoStory4ListMapper: PhotoStory4ListMapper = PhotoStory4ListMapper()
    override fun getAll(): Flow<List<Story4>> {
        return story4EntityDao.getAll().map { entities ->
            photoStory4ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        story4EntityDao.deleteAll()
    }

    override suspend fun insertStory4(story4: Story4) {
        val entity = photoStory4Mapper.mapToEntity(story4)
        story4EntityDao.insertStory(entity)
    }

    override suspend fun deleteStory4(story4: Story4) {
        val entity = photoStory4Mapper.mapToEntity(story4)
        story4EntityDao.deleteStory(entity)
    }
}