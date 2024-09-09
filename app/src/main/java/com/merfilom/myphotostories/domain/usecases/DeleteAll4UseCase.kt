package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository

class DeleteAll4UseCase(private val photo4Repository: Photo4Repository
) {
    suspend fun photoExecute(){
        return  photo4Repository.deleteAll()
    }
}