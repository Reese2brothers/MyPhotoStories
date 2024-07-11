package com.merfilom.myphotostories.data.mappers.photomapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo4

class Photo4Mapper : PhotoMapperInterface<Photo4Entity, Photo4> {
    override fun mapFromEntity(type: Photo4Entity): Photo4 {
        return Photo4( id = type.idEntity,
            title = type.titleEntity,
            content = type.contentEntity,
            image = type.imageEntity,)
    }

    override fun mapToEntity(type: Photo4): Photo4Entity {
        return Photo4Entity(idEntity = type.id,
            titleEntity = type.title,
            contentEntity = type.content,
            imageEntity = type.image,)
    }
}