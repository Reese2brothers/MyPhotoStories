package com.merfilom.myphotostories.data.mappers.photostorymapper

import com.merfilom.myphotostories.data.mappers.PhotoStoryMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import com.merfilom.myphotostories.data.models.photomodels.Story4Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.models.photomodels.Story4

class PhotoStory4Mapper : PhotoStoryMapperInterface<Story4Entity, Story4> {
    override fun mapFromEntity(type: Story4Entity): Story4 {
        return Story4(idStory4 = type.idStory4Entity,
            photoStory4 = Photo4(
                title = type.photoStory4Entity.titleEntity,
                content = type.photoStory4Entity.contentEntity,
                image = type.photoStory4Entity.imageEntity
            )
        )
    }

    override fun mapToEntity(type: Story4): Story4Entity {
        return Story4Entity(idStory4Entity = type.idStory4,
            photoStory4Entity = Photo4Entity(
                titleEntity = type.photoStory4.title,
                contentEntity = type.photoStory4.content,
                imageEntity = type.photoStory4.image
            )
        )
    }
}