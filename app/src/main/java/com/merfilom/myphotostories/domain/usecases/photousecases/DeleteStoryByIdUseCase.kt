package com.merfilom.myphotostories.domain.usecases.photousecases

import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository

class DeleteStoryByIdUseCase(
    private val story1Repository: PhotoStory1Repository
) {
    suspend fun storyExecute(storyId: String){
        return  story1Repository.deleteStoryById(storyId)
    }
}