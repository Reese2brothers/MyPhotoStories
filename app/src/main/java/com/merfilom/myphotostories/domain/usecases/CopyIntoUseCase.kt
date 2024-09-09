package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository

class CopyIntoUseCase(private val photoEmptyRepository: PhotoEmptyRepository
) {
    suspend fun photoExecute1(){
        return  photoEmptyRepository.copyInto1()
    }
    suspend fun photoExecute2(){
        return  photoEmptyRepository.copyInto2()
    }
    suspend fun photoExecute3(){
        return  photoEmptyRepository.copyInto3()
    }
    suspend fun photoExecute4(){
        return  photoEmptyRepository.copyInto4()
    }
    suspend fun photoExecute5(){
        return  photoEmptyRepository.copyInto5()
    }
}