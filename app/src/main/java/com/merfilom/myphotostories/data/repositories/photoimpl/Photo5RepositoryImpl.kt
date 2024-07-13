package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo5EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import kotlinx.coroutines.flow.Flow

class Photo5RepositoryImpl(photo5EntityDao: Photo5EntityDao) : Photo5Repository {
    override fun getAll(): Flow<List<Photo5>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertPhoto5(photo5: Photo5) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhoto5(photo5: Photo5) {
        TODO("Not yet implemented")
    }
}