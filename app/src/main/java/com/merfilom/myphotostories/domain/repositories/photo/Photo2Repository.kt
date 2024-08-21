package com.merfilom.myphotostories.domain.repositories.photo

import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import kotlinx.coroutines.flow.Flow

interface Photo2Repository {
    fun getAll() : Flow<List<Photo2>>

    suspend fun deleteAll()

    suspend fun insertPhoto2(photo2: Photo2)

    suspend fun deletePhoto2(photo2: Photo2)

    suspend fun getRowCount() : Int
}