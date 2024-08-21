package com.merfilom.myphotostories.data.mappers.photomapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty

class PhotoEmptyMapper : PhotoMapperInterface<PhotoEmptyEntity, PhotoEmpty> {
    override fun mapFromEntity(type: PhotoEmptyEntity): PhotoEmpty {
        return PhotoEmpty(
            content = type.contentEntity,
            image = type.imageEntity,)
    }

    override fun mapToEntity(type: PhotoEmpty): PhotoEmptyEntity {
        return PhotoEmptyEntity(
            contentEntity = type.content,
            imageEntity = type.image,)
    }
}