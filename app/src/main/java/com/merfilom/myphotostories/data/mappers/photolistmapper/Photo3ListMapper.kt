package com.merfilom.myphotostories.data.mappers.photolistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo3

class Photo3ListMapper: PhotoMapperInterface<List<Photo3Entity>, List<Photo3>> {
    override fun mapFromEntity(type: List<Photo3Entity>): List<Photo3> {
        val listPhoto = ArrayList<Photo3>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Photo3(
                    id = photoEntity.idEntity,
                    title = photoEntity.titleEntity,
                    content = photoEntity.contentEntity,
                    image = photoEntity.imageEntity,
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Photo3>): List<Photo3Entity> {
        val listPhotoEntity = ArrayList<Photo3Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Photo3Entity(
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