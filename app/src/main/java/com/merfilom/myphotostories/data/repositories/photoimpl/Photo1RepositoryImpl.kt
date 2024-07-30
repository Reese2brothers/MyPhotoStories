package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo1EntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.Photo1ListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.Photo1Mapper
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Photo1RepositoryImpl(private val photo1EntityDao: Photo1EntityDao) : Photo1Repository {
    private val photo1Mapper: Photo1Mapper = Photo1Mapper()
    private val photo1ListMapper: Photo1ListMapper = Photo1ListMapper()


    override fun getAll(): Flow<List<Photo1>> {
        return photo1EntityDao.getAll().map { entities ->
            photo1ListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun insertPhoto1(photo1: Photo1) {
        val entity = photo1Mapper.mapToEntity(photo1)
        photo1EntityDao.insertPhoto(entity)
    }

    override suspend fun deletePhoto1(photo1: Photo1) {
        val entity = photo1Mapper.mapToEntity(photo1)
        photo1EntityDao.deletePhoto(entity)
    }
}