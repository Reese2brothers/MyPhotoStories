package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.models.photomodels.Story2
import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory2Repository
import kotlinx.coroutines.flow.Flow

class GetAll2UseCase(private val photo2Repository: Photo2Repository,
                     private val photoStory2Repository: PhotoStory2Repository
) {
    fun photoExecute(): Flow<List<Photo2>> {
        return  photo2Repository.getAll()
    }
    fun storyExecute(): Flow<List<Story2>> {
        return  photoStory2Repository.getAll()
    }
}