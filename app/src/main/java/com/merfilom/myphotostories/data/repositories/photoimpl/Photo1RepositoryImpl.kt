package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository
import kotlinx.coroutines.flow.Flow

class Photo1RepositoryImpl : Photo1Repository {
    override fun getAll(): Flow<List<Photo1>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertPhoto1(photo1: Photo1) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhoto1(photo1: Photo1) {
        TODO("Not yet implemented")
    }
}