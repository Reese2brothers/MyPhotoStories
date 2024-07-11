package com.merfilom.myphotostories.data.mappers.photomapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo1

class Photo1Mapper : PhotoMapperInterface<Photo1Entity, Photo1> {
    override fun mapFromEntity(type: Photo1Entity): Photo1 {
        return Photo1( id = type.idEntity,
            title = type.titleEntity,
            content = type.contentEntity,
            image = type.imageEntity,)
    }

    override fun mapToEntity(type: Photo1): Photo1Entity {
        return Photo1Entity(idEntity = type.id,
            titleEntity = type.title,
            contentEntity = type.content,
            imageEntity = type.image,)
    }
}