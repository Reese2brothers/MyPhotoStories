package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.Story5
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory5Repository
import kotlinx.coroutines.flow.Flow

class GetAll5UseCase(private val photo5Repository: Photo5Repository,
                     private val photoStory5Repository: PhotoStory5Repository
) {
    fun photoExecute(): Flow<List<Photo5>> {
        return  photo5Repository.getAll()
    }
    fun storyExecute(): Flow<List<Story5>> {
        return  photoStory5Repository.getAll()
    }
}