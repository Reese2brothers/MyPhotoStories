package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository

class GetRowCount4UseCase(private val photo4Repository: Photo4Repository,
) {
    suspend fun photoExecute() : Int {
        return  photo4Repository.getRowCount()
    }
}