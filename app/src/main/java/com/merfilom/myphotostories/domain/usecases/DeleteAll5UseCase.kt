package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory5Repository

class DeleteAll5UseCase(private val photo5Repository: Photo5Repository,
                        private val story5Repository: PhotoStory5Repository
) {
    suspend fun photoExecute(){
        return  photo5Repository.deleteAll()
    }
    suspend fun storyExecute(){
        return  story5Repository.deleteAll()
    }
}