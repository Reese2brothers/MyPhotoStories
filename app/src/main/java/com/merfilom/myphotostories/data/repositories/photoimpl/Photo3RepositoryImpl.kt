package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.Photo3EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository
import kotlinx.coroutines.flow.Flow

class Photo3RepositoryImpl(photo3EntityDao: Photo3EntityDao) : Photo3Repository {
    override fun getAll(): Flow<List<Photo3>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertPhoto3(photo3: Photo3) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhoto3(photo3: Photo3) {
        TODO("Not yet implemented")
    }
}