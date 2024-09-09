package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository

class Insert5UseCase(private val photo5Repository: Photo5Repository
) {
    suspend fun photoExecute(photo5: Photo5){
        return  photo5Repository.insertPhoto5(photo5 = photo5)
    }
}