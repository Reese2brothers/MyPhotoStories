package com.merfilom.myphotostories.data.mappers.photolistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo1

class Photo1ListMapper: PhotoMapperInterface<List<Photo1Entity>, List<Photo1>> {
    override fun mapFromEntity(type: List<Photo1Entity>): List<Photo1> {
        val listPhoto = ArrayList<Photo1>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Photo1(
                    id = photoEntity.idEntity,
                    title = photoEntity.titleEntity,
                    content = photoEntity.contentEntity,
                    image = photoEntity.imageEntity,
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Photo1>): List<Photo1Entity> {
        val listPhotoEntity = ArrayList<Photo1Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Photo1Entity(
                    idEntity = photo.id,
                    titleEntity = photo.title,
                    contentEntity = photo.content,
                    imageEntity = photo.image,
                )
            )
        }
        return listPhotoEntity.toList()
    }
}