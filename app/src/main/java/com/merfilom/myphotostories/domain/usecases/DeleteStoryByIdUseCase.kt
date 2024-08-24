package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository

class DeleteStoryByIdUseCase(
    private val story1Repository: PhotoStory1Repository
) {
    suspend fun storyExecute(storyId: Int){
        return  story1Repository.deleteStoryById(storyId)
    }
}