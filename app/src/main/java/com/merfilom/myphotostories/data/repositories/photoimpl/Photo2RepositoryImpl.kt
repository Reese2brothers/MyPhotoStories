package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo2EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository
import kotlinx.coroutines.flow.Flow

class Photo2RepositoryImpl(photo2EntityDao: Photo2EntityDao) : Photo2Repository {
    override fun getAll(): Flow<List<Photo2>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertPhoto2(photo2: Photo2) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhoto2(photo2: Photo2) {
        TODO("Not yet implemented")
    }
}