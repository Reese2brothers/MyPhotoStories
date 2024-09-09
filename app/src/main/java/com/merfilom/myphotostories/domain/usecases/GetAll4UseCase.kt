package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import kotlinx.coroutines.flow.Flow

class GetAll4UseCase(private val photo4Repository: Photo4Repository
) {
    fun photoExecute(): Flow<List<Photo4>> {
        return  photo4Repository.getAll()
    }
}