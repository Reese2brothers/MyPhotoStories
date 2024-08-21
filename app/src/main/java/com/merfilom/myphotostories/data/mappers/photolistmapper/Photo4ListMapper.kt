package com.merfilom.myphotostories.data.mappers.photolistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo4

class Photo4ListMapper: PhotoMapperInterface<List<Photo4Entity>, List<Photo4>> {
    override fun mapFromEntity(type: List<Photo4Entity>): List<Photo4> {
        val listPhoto = ArrayList<Photo4>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Photo4(
                    content = photoEntity.contentEntity,
                    image = photoEntity.imageEntity,
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Photo4>): List<Photo4Entity> {
        val listPhotoEntity = ArrayList<Photo4Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Photo4Entity(
                    contentEntity = photo.content,
                    imageEntity = photo.image,
                )
            )
        }
        return listPhotoEntity.toList()
    }
}