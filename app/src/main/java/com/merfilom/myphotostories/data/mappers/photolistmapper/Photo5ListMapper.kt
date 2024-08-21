package com.merfilom.myphotostories.data.mappers.photolistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo5

class Photo5ListMapper: PhotoMapperInterface<List<Photo5Entity>, List<Photo5>> {
    override fun mapFromEntity(type: List<Photo5Entity>): List<Photo5> {
        val listPhoto = ArrayList<Photo5>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Photo5(
                    content = photoEntity.contentEntity,
                    image = photoEntity.imageEntity,
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Photo5>): List<Photo5Entity> {
        val listPhotoEntity = ArrayList<Photo5Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Photo5Entity(
                    contentEntity = photo.content,
                    imageEntity = photo.image,
                )
            )
        }
        return listPhotoEntity.toList()
    }
}