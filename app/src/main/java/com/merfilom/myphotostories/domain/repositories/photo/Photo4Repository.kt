package com.merfilom.myphotostories.domain.repositories.photo

import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import kotlinx.coroutines.flow.Flow

interface Photo4Repository {
    fun getAll() : Flow<List<Photo4>>

    suspend fun insertPhoto4(photo4: Photo4)

    suspend fun deletePhoto4(photo4: Photo4)
}