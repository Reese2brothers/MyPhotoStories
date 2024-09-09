package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository

class DeleteAll5UseCase(private val photo5Repository: Photo5Repository
) {
    suspend fun photoExecute(){
        return  photo5Repository.deleteAll()
    }
}