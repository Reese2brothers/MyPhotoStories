package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo4EntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.Photo4ListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.Photo4Mapper
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Photo4RepositoryImpl(private val photo4EntityDao: Photo4EntityDao) : Photo4Repository {
    private val photo4Mapper: Photo4Mapper = Photo4Mapper()
    private val photo4ListMapper: Photo4ListMapper = Photo4ListMapper()
    override fun getAll(): Flow<List<Photo4>> {
        return photo4EntityDao.getAll().map { entities ->
            photo4ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        photo4EntityDao.deleteAll()
    }

    override suspend fun insertPhoto4(photo4: Photo4) {
        val entity = photo4Mapper.mapToEntity(photo4)
        photo4EntityDao.insertPhoto(entity)
    }

    override suspend fun deletePhoto4(photo4: Photo4) {
        val entity = photo4Mapper.mapToEntity(photo4)
        photo4EntityDao.deletePhoto(entity.imageEntity, entity.contentEntity)
    }
    override suspend fun getRowCount(): Int {
        return photo4EntityDao.getRowCount()
    }
}