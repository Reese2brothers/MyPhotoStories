package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository

class DecrementAllStory1IdsUseCase(
    private val story1Repository: PhotoStory1Repository
) {
    suspend fun storyExecute(){
        return  story1Repository.decrementAllStory1Ids()
    }
    suspend fun decrementIdsAfterDeleted(deletedId: Int){
        return story1Repository.decrementIdsAfterDeleted(deletedId)
    }
}