package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory3Repository

class DeleteAll3UseCase(private val photo3Repository: Photo3Repository,
                        private val story3Repository: PhotoStory3Repository
) {
    suspend fun photoExecute(){
        return  photo3Repository.deleteAll()
    }
    suspend fun storyExecute(){
        return  story3Repository.deleteAll()
    }
}