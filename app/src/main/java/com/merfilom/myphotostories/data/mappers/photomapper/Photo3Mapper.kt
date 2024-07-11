package com.merfilom.myphotostories.data.mappers.photomapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo3

class Photo3Mapper : PhotoMapperInterface<Photo3Entity, Photo3> {
    override fun mapFromEntity(type: Photo3Entity): Photo3 {
        return Photo3( id = type.idEntity,
            title = type.titleEntity,
            content = type.contentEntity,
            image = type.imageEntity,)
    }

    override fun mapToEntity(type: Photo3): Photo3Entity {
        return Photo3Entity(idEntity = type.id,
            titleEntity = type.title,
            contentEntity = type.content,
            imageEntity = type.image,)
    }
}