package com.merfilom.myphotostories.data.mappers.photolistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo2

class Photo2ListMapper: PhotoMapperInterface<List<Photo2Entity>, List<Photo2>> {
    override fun mapFromEntity(type: List<Photo2Entity>): List<Photo2> {
        val listPhoto = ArrayList<Photo2>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Photo2(
                    content = photoEntity.contentEntity,
                    image = photoEntity.imageEntity,
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Photo2>): List<Photo2Entity> {
        val listPhotoEntity = ArrayList<Photo2Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Photo2Entity(
                    contentEntity = photo.content,
                    imageEntity = photo.image,
                )
            )
        }
        return listPhotoEntity.toList()
    }
}