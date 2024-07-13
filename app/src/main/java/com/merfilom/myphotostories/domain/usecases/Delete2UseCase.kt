package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.models.photomodels.Story2
import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory2Repository

class Delete2UseCase(private val photo2Repository: Photo2Repository,
                     private val story2Repository: PhotoStory2Repository
) {
    suspend fun photoExecute(photo2: Photo2){
        return  photo2Repository.deletePhoto2(photo2 = photo2)
    }
    suspend fun storyExecute(story2: Story2){
        return  story2Repository.deleteStory2(story2 = story2)
    }
}