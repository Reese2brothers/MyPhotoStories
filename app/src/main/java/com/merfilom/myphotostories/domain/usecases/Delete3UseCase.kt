package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.models.photomodels.Story3
import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory3Repository

class Delete3UseCase(private val photo3Repository: Photo3Repository,
                     private val story3Repository: PhotoStory3Repository
) {
    suspend fun photoExecute(photo3: Photo3){
        return  photo3Repository.deletePhoto3(photo3 = photo3)
    }
    suspend fun storyExecute(story3: Story3){
        return  story3Repository.deleteStory3(story3 = story3)
    }
}