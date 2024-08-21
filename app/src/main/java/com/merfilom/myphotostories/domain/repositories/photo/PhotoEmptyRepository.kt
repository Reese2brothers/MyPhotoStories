package com.merfilom.myphotostories.domain.repositories.photo

import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import kotlinx.coroutines.flow.Flow

interface PhotoEmptyRepository {
    fun getAll() : Flow<List<PhotoEmpty>>

    suspend fun deleteAll()

    suspend fun insertPhotoEmpty(photoEmpty: PhotoEmpty)

    suspend fun deletePhotoEmpty(photoEmpty: PhotoEmpty)

    suspend fun copyInto1()
    suspend fun copyInto2()
    suspend fun copyInto3()
    suspend fun copyInto4()
    suspend fun copyInto5()

}