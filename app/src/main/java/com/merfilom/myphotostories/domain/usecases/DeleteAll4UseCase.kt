package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory4Repository

class DeleteAll4UseCase(private val photo4Repository: Photo4Repository,
                        private val story4Repository: PhotoStory4Repository
) {
    suspend fun photoExecute(){
        return  photo4Repository.deleteAll()
    }
    suspend fun storyExecute(){
        return  story4Repository.deleteAll()
    }
}