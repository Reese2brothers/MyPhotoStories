package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.PhotoEmptyEntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.PhotoEmptyListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.PhotoEmptyMapper
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoEmptyRepositoryImpl(private val photoEmptyEntityDao: PhotoEmptyEntityDao) : PhotoEmptyRepository {
    private val photoEmptyMapper: PhotoEmptyMapper = PhotoEmptyMapper()
    private val photoEmptyListMapper: PhotoEmptyListMapper = PhotoEmptyListMapper()


    override fun getAll(): Flow<List<PhotoEmpty>> {
        return photoEmptyEntityDao.getAll().map { entities ->
            photoEmptyListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        photoEmptyEntityDao.deleteAll()
    }

    override suspend fun insertPhotoEmpty(photoEmpty: PhotoEmpty) {
        val entity = photoEmptyMapper.mapToEntity(photoEmpty)
        photoEmptyEntityDao.insertPhoto(entity)
    }

    override suspend fun deletePhotoEmpty(photoEmpty: PhotoEmpty) {
        val entity = photoEmptyMapper.mapToEntity(photoEmpty)
        photoEmptyEntityDao.deletePhoto(entity.imageEntity, entity.contentEntity)
    }

    override suspend fun copyInto1() {
        photoEmptyEntityDao.copyInto1()
    }

    override suspend fun copyInto2() {
       photoEmptyEntityDao.copyInto2()
    }

    override suspend fun copyInto3() {
        photoEmptyEntityDao.copyInto3()
    }

    override suspend fun copyInto4() {
        photoEmptyEntityDao.copyInto4()
    }

    override suspend fun copyInto5() {
        photoEmptyEntityDao.copyInto5()
    }
}