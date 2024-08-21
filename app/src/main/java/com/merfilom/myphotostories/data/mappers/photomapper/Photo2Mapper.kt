package com.merfilom.myphotostories.data.mappers.photomapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo2

class Photo2Mapper : PhotoMapperInterface<Photo2Entity, Photo2> {
    override fun mapFromEntity(type: Photo2Entity): Photo2 {
        return Photo2(
            content = type.contentEntity,
            image = type.imageEntity,)
    }

    override fun mapToEntity(type: Photo2): Photo2Entity {
        return Photo2Entity(
            contentEntity = type.content,
            imageEntity = type.image,)
    }
}