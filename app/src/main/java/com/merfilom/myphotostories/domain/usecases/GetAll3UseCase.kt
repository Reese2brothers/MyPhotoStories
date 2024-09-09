package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository
import kotlinx.coroutines.flow.Flow

class GetAll3UseCase(private val photo3Repository: Photo3Repository
) {
    fun photoExecute(): Flow<List<Photo3>> {
        return  photo3Repository.getAll()
    }
}