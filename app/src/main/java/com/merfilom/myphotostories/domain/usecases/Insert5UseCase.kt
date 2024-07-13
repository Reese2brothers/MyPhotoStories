package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.Story5
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory5Repository

class Insert5UseCase(private val photo5Repository: Photo5Repository,
                     private val story5Repository: PhotoStory5Repository
) {
    suspend fun photoExecute(photo5: Photo5){
        return  photo5Repository.insertPhoto5(photo5 = photo5)
    }
    suspend fun storyExecute(story5: Story5){
        return  story5Repository.insertStory5(story5 = story5)
    }
}