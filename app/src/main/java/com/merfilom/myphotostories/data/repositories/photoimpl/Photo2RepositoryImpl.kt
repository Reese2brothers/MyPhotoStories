package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo2EntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.Photo2ListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.Photo2Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Photo2RepositoryImpl(private val photo2EntityDao: Photo2EntityDao) : Photo2Repository {
    private val photo2Mapper: Photo2Mapper = Photo2Mapper()
    private val photo2ListMapper: Photo2ListMapper = Photo2ListMapper()
    override fun getAll(): Flow<List<Photo2>> {
        return photo2EntityDao.getAll().map { entities ->
            photo2ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        photo2EntityDao.deleteAll()
    }

    override suspend fun insertPhoto2(photo2: Photo2) {
        val entity = photo2Mapper.mapToEntity(photo2)
        photo2EntityDao.insertPhoto(entity)
    }

    override suspend fun deletePhoto2(photo2: Photo2) {
        val entity = photo2Mapper.mapToEntity(photo2)
        photo2EntityDao.deletePhoto(entity.imageEntity, entity.contentEntity)
    }
}