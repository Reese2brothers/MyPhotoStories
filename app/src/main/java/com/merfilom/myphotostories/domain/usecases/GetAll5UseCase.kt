package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import kotlinx.coroutines.flow.Flow

class GetAll5UseCase(private val photo5Repository: Photo5Repository
) {
    fun photoExecute(): Flow<List<Photo5>> {
        return  photo5Repository.getAll()
    }
}