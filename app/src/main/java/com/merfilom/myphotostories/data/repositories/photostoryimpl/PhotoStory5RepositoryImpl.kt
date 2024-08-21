package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.Story5EntityDao
import com.merfilom.myphotostories.data.mappers.photostorylistmapper.PhotoStory5ListMapper
import com.merfilom.myphotostories.data.mappers.photostorymapper.PhotoStory5Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Story5
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory5Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoStory5RepositoryImpl(private val story5EntityDao: Story5EntityDao) :
    PhotoStory5Repository {
    private val photoStory5Mapper: PhotoStory5Mapper = PhotoStory5Mapper()
    private val photoStory5ListMapper: PhotoStory5ListMapper = PhotoStory5ListMapper()
    override fun getAll(): Flow<List<Story5>> {
        return story5EntityDao.getAll().map { entities ->
            photoStory5ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        story5EntityDao.deleteAll()
    }

    override suspend fun insertStory5(story5: Story5) {
        val entity = photoStory5Mapper.mapToEntity(story5)
        story5EntityDao.insertStory(entity)
    }

    override suspend fun deleteStory5(story5: Story5) {
        val entity = photoStory5Mapper.mapToEntity(story5)
        story5EntityDao.deleteStory(entity)
    }
}