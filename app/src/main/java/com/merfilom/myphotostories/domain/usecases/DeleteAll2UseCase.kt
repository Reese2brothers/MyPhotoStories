package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory2Repository

class DeleteAll2UseCase(private val photo2Repository: Photo2Repository,
                        private val story2Repository: PhotoStory2Repository
) {
    suspend fun photoExecute(){
        return  photo2Repository.deleteAll()
    }
    suspend fun storyExecute(){
        return  story2Repository.deleteAll()
    }
}