package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository

class DeleteAll1UseCase(private val photo1Repository: Photo1Repository,
                     private val story1Repository: PhotoStory1Repository
) {
    suspend fun photoExecute(){
        return  photo1Repository.deleteAll()
    }
    suspend fun storyExecute(){
        return  story1Repository.deleteAll()
    }
}