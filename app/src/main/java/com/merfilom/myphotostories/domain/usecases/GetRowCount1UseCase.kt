package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository

class GetRowCount1UseCase(private val photo1Repository: Photo1Repository,
) {
    suspend fun photoExecute() : Int {
        return  photo1Repository.getRowCount()
    }
}