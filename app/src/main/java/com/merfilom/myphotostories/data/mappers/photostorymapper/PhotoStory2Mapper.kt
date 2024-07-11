package com.merfilom.myphotostories.data.mappers.photostorymapper

import com.merfilom.myphotostories.data.mappers.PhotoStoryMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import com.merfilom.myphotostories.data.models.photomodels.Story2Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.models.photomodels.Story2

class PhotoStory2Mapper : PhotoStoryMapperInterface<Story2Entity, Story2> {
    override fun mapFromEntity(type: Story2Entity): Story2 {
        return Story2(idStory2 = type.idStory2Entity,
            photoStory2 = Photo2(
                title = type.photoStory2Entity.titleEntity,
                content = type.photoStory2Entity.contentEntity,
                image = type.photoStory2Entity.imageEntity
            )
        )
    }

    override fun mapToEntity(type: Story2): Story2Entity {
        return Story2Entity(idStory2Entity = type.idStory2,
            photoStory2Entity = Photo2Entity(
                titleEntity = type.photoStory2.title,
                contentEntity = type.photoStory2.content,
                imageEntity = type.photoStory2.image
            )
        )
    }
}