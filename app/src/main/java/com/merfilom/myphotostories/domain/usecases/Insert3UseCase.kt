package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository

class Insert3UseCase(private val photo3Repository: Photo3Repository
) {
    suspend fun photoExecute(photo3: Photo3){
        return  photo3Repository.insertPhoto3(photo3 = photo3)
    }
}