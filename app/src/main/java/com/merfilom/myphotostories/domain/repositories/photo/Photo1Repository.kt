package com.merfilom.myphotostories.domain.repositories.photo

import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import kotlinx.coroutines.flow.Flow

interface Photo1Repository {
    fun getAll() : Flow<List<Photo1>>

    suspend fun deleteAll()

    suspend fun insertPhoto1(photo1: Photo1)

    suspend fun deletePhoto1(photo1: Photo1)

    suspend fun getRowCount() : Int

}