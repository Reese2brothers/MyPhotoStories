package com.merfilom.myphotostories.data.repositories.photostoryimpl

import com.merfilom.myphotostories.data.dao.photodao.StoryEmptyEntityDao
import com.merfilom.myphotostories.data.mappers.photostorylistmapper.PhotoStoryEmptyListMapper
import com.merfilom.myphotostories.data.mappers.photostorymapper.PhotoStoryEmptyMapper
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStoryEmptyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoStoryEmptyRepositoryImpl(private val storyEmptyEntityDao: StoryEmptyEntityDao) :
    PhotoStoryEmptyRepository {
    private val photoStoryEmptyMapper: PhotoStoryEmptyMapper = PhotoStoryEmptyMapper()
    private val photoStoryEmptyListMapper: PhotoStoryEmptyListMapper = PhotoStoryEmptyListMapper()
    override fun getAll(): Flow<List<StoryEmpty>> {
        return storyEmptyEntityDao.getAll().map { entities ->
            photoStoryEmptyListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        storyEmptyEntityDao.deleteAll()
    }

    override suspend fun insertStoryEmpty(storyEmpty: StoryEmpty) {
        val entity = photoStoryEmptyMapper.mapToEntity(storyEmpty)
        storyEmptyEntityDao.insertStory(entity)
    }

    override suspend fun deleteStoryEmpty(storyEmpty: StoryEmpty) {
        val entity = photoStoryEmptyMapper.mapToEntity(storyEmpty)
        storyEmptyEntityDao.deleteStory(entity)
    }
}