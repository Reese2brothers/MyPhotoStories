package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository

class Delete2UseCase(private val photo2Repository: Photo2Repository
) {
    suspend fun photoExecute(photo2: Photo2){
        return  photo2Repository.deletePhoto2(photo2 = photo2)
    }
}