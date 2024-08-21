package com.merfilom.myphotostories.data.mappers.photostorymapper

import com.merfilom.myphotostories.data.mappers.PhotoStoryMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import com.merfilom.myphotostories.data.models.photomodels.StoryEmptyEntity
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty

class PhotoStoryEmptyMapper : PhotoStoryMapperInterface<StoryEmptyEntity, StoryEmpty> {
    override fun mapFromEntity(type: StoryEmptyEntity): StoryEmpty {
        return StoryEmpty(
            photoStoryEmpty = PhotoEmpty(
                content = type.photoStoryEmptyEntity.contentEntity,
                image = type.photoStoryEmptyEntity.imageEntity
            )
        )
    }

    override fun mapToEntity(type: StoryEmpty): StoryEmptyEntity {
        return StoryEmptyEntity(
            photoStoryEmptyEntity = PhotoEmptyEntity(
                contentEntity = type.photoStoryEmpty.content,
                imageEntity = type.photoStoryEmpty.image
            )
        )
    }
}