package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo4EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import kotlinx.coroutines.flow.Flow

class Photo4RepositoryImpl(photo4EntityDao: Photo4EntityDao) : Photo4Repository {
    override fun getAll(): Flow<List<Photo4>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertPhoto4(photo4: Photo4) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhoto4(photo4: Photo4) {
        TODO("Not yet implemented")
    }
}