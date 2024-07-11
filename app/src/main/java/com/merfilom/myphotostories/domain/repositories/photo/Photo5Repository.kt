package com.merfilom.myphotostories.domain.repositories.photo

import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import kotlinx.coroutines.flow.Flow

interface Photo5Repository {
    fun getAll() : Flow<List<Photo5>>

    suspend fun insertPhoto5(photo5: Photo5)

    suspend fun deletePhoto5(photo5: Photo5)
}