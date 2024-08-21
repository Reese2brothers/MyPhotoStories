package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository

class GetRowCount3UseCase(private val photo3Repository: Photo3Repository,
) {
    suspend fun photoExecute() : Int {
        return  photo3Repository.getRowCount()
    }
}