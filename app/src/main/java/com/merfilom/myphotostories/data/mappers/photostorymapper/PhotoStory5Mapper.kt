package com.merfilom.myphotostories.data.mappers.photostorymapper

import com.merfilom.myphotostories.data.mappers.PhotoStoryMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import com.merfilom.myphotostories.data.models.photomodels.Story5Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.Story5

class PhotoStory5Mapper : PhotoStoryMapperInterface<Story5Entity, Story5> {
    override fun mapFromEntity(type: Story5Entity): Story5 {
        return Story5(
            photoStory5 = Photo5(
                content = type.photoStory5Entity.contentEntity,
                image = type.photoStory5Entity.imageEntity
            )
        )
    }

    override fun mapToEntity(type: Story5): Story5Entity {
        return Story5Entity(
            photoStory5Entity = Photo5Entity(
                contentEntity = type.photoStory5.content,
                imageEntity = type.photoStory5.image
            )
        )
    }
}