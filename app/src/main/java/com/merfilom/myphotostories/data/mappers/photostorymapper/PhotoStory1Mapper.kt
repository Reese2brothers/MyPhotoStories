package com.merfilom.myphotostories.data.mappers.photostorymapper

import com.merfilom.myphotostories.data.mappers.PhotoStoryMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Story1Entity
import com.merfilom.myphotostories.domain.models.photomodels.Story1

class PhotoStory1Mapper : PhotoStoryMapperInterface<Story1Entity, Story1> {
    override fun mapFromEntity(type: Story1Entity): Story1 {
        return Story1(
            idName = type.idNameEntity,
            image = type.imageEntity
        )
    }

    override fun mapToEntity(type: Story1): Story1Entity {
        return Story1Entity(
            idNameEntity = type.idName,
            imageEntity = type.image)
    }
}