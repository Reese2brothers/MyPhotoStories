package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.models.photomodels.Story4
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory4Repository

class Insert4UseCase(private val photo4Repository: Photo4Repository,
                     private val story4Repository: PhotoStory4Repository
) {
    suspend fun photoExecute(photo4: Photo4){
        return  photo4Repository.insertPhoto4(photo4 = photo4)
    }
    suspend fun storyExecute(story4: Story4){
        return  story4Repository.insertStory4(story4 = story4)
    }
}