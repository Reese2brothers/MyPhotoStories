package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository

class Delete1UseCase(private val photo1Repository: Photo1Repository,
                     private val story1Repository: PhotoStory1Repository
) {
    suspend fun photoExecute(photo1: Photo1){
        return  photo1Repository.deletePhoto1(photo1 = photo1)
    }
    suspend fun storyExecute(story1: Story1){
        return  story1Repository.deleteStory1(story1 = story1)
    }
}