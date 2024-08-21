package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty
import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStoryEmptyRepository

class DeleteEmptyUseCase(private val photoEmptyRepository: PhotoEmptyRepository,
                     private val storyEmptyRepository: PhotoStoryEmptyRepository
) {
    suspend fun photoExecute(photoEmpty: PhotoEmpty){
        return  photoEmptyRepository.deletePhotoEmpty(photoEmpty = photoEmpty)
    }
    suspend fun storyExecute(storyEmpty: StoryEmpty){
        return  storyEmptyRepository.deleteStoryEmpty(storyEmpty = storyEmpty)
    }
}