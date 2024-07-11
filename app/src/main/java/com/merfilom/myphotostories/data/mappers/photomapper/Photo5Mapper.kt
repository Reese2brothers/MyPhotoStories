package com.merfilom.myphotostories.data.mappers.photomapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo5

class Photo5Mapper : PhotoMapperInterface<Photo5Entity, Photo5> {
    override fun mapFromEntity(type: Photo5Entity): Photo5 {
        return Photo5( id = type.idEntity,
            title = type.titleEntity,
            content = type.contentEntity,
            image = type.imageEntity,)
    }

    override fun mapToEntity(type: Photo5): Photo5Entity {
        return Photo5Entity(idEntity = type.id,
            titleEntity = type.title,
            contentEntity = type.content,
            imageEntity = type.image,)
    }
}