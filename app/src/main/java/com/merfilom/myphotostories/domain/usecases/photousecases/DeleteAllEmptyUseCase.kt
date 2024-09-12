package com.merfilom.myphotostories.domain.usecases.photousecases

import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStoryEmptyRepository

class DeleteAllEmptyUseCase(private val photoEmptyRepository: PhotoEmptyRepository,
                        private val storyEmptyRepository: PhotoStoryEmptyRepository
) {
    suspend fun photoExecute(){
        return  photoEmptyRepository.deleteAll()
    }
    suspend fun storyExecute(){
        return  storyEmptyRepository.deleteAll()
    }
}