package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo5EntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.Photo5ListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.Photo5Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Photo5RepositoryImpl(private val photo5EntityDao: Photo5EntityDao) : Photo5Repository {
    private val photo5Mapper: Photo5Mapper = Photo5Mapper()
    private val photo5ListMapper: Photo5ListMapper = Photo5ListMapper()
    override fun getAll(): Flow<List<Photo5>> {
        return photo5EntityDao.getAll().map { entities ->
            photo5ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        photo5EntityDao.deleteAll()
    }

    override suspend fun insertPhoto5(photo5: Photo5) {
        val entity = photo5Mapper.mapToEntity(photo5)
        photo5EntityDao.insertPhoto(entity)
    }

    override suspend fun deletePhoto5(photo5: Photo5) {
        val entity = photo5Mapper.mapToEntity(photo5)
        photo5EntityDao.deletePhoto(entity.imageEntity, entity.contentEntity)
    }
    override suspend fun getRowCount(): Int {
        return photo5EntityDao.getRowCount()
    }
}