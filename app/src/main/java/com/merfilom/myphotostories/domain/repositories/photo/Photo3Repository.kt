package com.merfilom.myphotostories.domain.repositories.photo

import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import kotlinx.coroutines.flow.Flow

interface Photo3Repository {
    fun getAll() : Flow<List<Photo3>>

    suspend fun insertPhoto3(photo3: Photo3)

    suspend fun deletePhoto3(photo3: Photo3)
}