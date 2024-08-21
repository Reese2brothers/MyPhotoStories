package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty
import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStoryEmptyRepository
import kotlinx.coroutines.flow.Flow

class GetAllEmptyUseCase(private val photoEmptyRepository: PhotoEmptyRepository,
                     private val photoStoryEmptyRepository: PhotoStoryEmptyRepository
) {
    fun photoExecute(): Flow<List<PhotoEmpty>> {
        return  photoEmptyRepository.getAll()
    }
    fun storyExecute(): Flow<List<StoryEmpty>> {
        return  photoStoryEmptyRepository.getAll()
    }
}