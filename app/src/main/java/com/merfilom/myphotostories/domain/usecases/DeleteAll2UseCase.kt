package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository

class DeleteAll2UseCase(private val photo2Repository: Photo2Repository
) {
    suspend fun photoExecute(){
        return  photo2Repository.deleteAll()
    }
}