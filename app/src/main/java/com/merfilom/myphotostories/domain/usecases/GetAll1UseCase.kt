package com.merfilom.myphotostories.domain.usecases

import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository
import kotlinx.coroutines.flow.Flow

class GetAll1UseCase(private val photo1Repository: Photo1Repository,
                     private val photoStory1Repository: PhotoStory1Repository
) {
    fun photoExecute(): Flow<List<Photo1>> {
        return  photo1Repository.getAll()
    }
    fun storyExecute():Flow<List<Story1>>{
        return  photoStory1Repository.getAll()
    }
}