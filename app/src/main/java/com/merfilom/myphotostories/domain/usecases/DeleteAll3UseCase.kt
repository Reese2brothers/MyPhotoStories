package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository

class DeleteAll3UseCase(private val photo3Repository: Photo3Repository
) {
    suspend fun photoExecute(){
        return  photo3Repository.deleteAll()
    }
}