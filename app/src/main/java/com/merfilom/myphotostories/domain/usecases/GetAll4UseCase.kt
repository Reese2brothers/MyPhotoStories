package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.models.photomodels.Story4
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory4Repository
import kotlinx.coroutines.flow.Flow

class GetAll4UseCase(private val photo4Repository: Photo4Repository,
                     private val photoStory4Repository: PhotoStory4Repository
) {
    fun photoExecute(): Flow<List<Photo4>> {
        return  photo4Repository.getAll()
    }
    fun storyExecute(): Flow<List<Story4>> {
        return  photoStory4Repository.getAll()
    }
}