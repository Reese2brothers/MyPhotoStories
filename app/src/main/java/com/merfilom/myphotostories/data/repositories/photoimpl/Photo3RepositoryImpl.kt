package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo3EntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.Photo3ListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.Photo3Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Photo3RepositoryImpl(private val photo3EntityDao: Photo3EntityDao) : Photo3Repository {
    private val photo3Mapper: Photo3Mapper = Photo3Mapper()
    private val photo3ListMapper: Photo3ListMapper = Photo3ListMapper()


    override fun getAll(): Flow<List<Photo3>> {
        return photo3EntityDao.getAll().map { entities ->
            photo3ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        photo3EntityDao.deleteAll()
    }

    override suspend fun insertPhoto3(photo3: Photo3) {
        val entity = photo3Mapper.mapToEntity(photo3)
        photo3EntityDao.insertPhoto(entity)
    }

    override suspend fun deletePhoto3(photo3: Photo3) {
        val entity = photo3Mapper.mapToEntity(photo3)
        photo3EntityDao.deletePhoto(entity.imageEntity, entity.contentEntity)
    }
    override suspend fun getRowCount(): Int {
        return photo3EntityDao.getRowCount()
    }
}