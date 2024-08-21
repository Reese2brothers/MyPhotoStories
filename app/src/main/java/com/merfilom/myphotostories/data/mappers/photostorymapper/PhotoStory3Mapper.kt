package com.merfilom.myphotostories.data.mappers.photostorymapper

import com.merfilom.myphotostories.data.mappers.PhotoStoryMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import com.merfilom.myphotostories.data.models.photomodels.Story3Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.models.photomodels.Story3

class PhotoStory3Mapper : PhotoStoryMapperInterface<Story3Entity, Story3> {
    override fun mapFromEntity(type: Story3Entity): Story3 {
        return Story3(
            photoStory3 = Photo3(
                content = type.photoStory3Entity.contentEntity,
                image = type.photoStory3Entity.imageEntity
            )
        )
    }

    override fun mapToEntity(type: Story3): Story3Entity {
        return Story3Entity(
            photoStory3Entity = Photo3Entity(
                contentEntity = type.photoStory3.content,
                imageEntity = type.photoStory3.image
            )
        )
    }
}