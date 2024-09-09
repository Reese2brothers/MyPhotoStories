package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository

class Insert4UseCase(private val photo4Repository: Photo4Repository
) {
    suspend fun photoExecute(photo4: Photo4){
        return  photo4Repository.insertPhoto4(photo4 = photo4)
    }
}