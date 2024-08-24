package com.merfilom.myphotostories.data.mappers.photostorymapper

import com.merfilom.myphotostories.data.mappers.PhotoStoryMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.data.models.photomodels.Story1Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1

class PhotoStory1Mapper : PhotoStoryMapperInterface<Story1Entity, Story1> {
    override fun mapFromEntity(type: Story1Entity): Story1 {
        return Story1(
            //id = type.idStory1Entity,
            image = type.imageEntity
        )
    }

    override fun mapToEntity(type: Story1): Story1Entity {
        return Story1Entity(
            //idStory1Entity = type.id,
            imageEntity = type.image)
    }
}