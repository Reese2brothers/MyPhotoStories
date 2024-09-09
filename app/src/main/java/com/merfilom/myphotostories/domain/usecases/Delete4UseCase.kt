package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository

class Delete4UseCase(private val photo4Repository: Photo4Repository
) {
    suspend fun photoExecute(photo4: Photo4){
        return  photo4Repository.deletePhoto4(photo4 = photo4)
    }
}