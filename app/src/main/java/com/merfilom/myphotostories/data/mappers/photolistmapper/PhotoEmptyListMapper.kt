package com.merfilom.myphotostories.data.mappers.photolistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty

class PhotoEmptyListMapper: PhotoMapperInterface<List<PhotoEmptyEntity>, List<PhotoEmpty>> {
    override fun mapFromEntity(type: List<PhotoEmptyEntity>): List<PhotoEmpty> {
        val listPhoto = ArrayList<PhotoEmpty>()

        type.forEach { photoEntity ->
            listPhoto.add(
                PhotoEmpty(
                    content = photoEntity.contentEntity,
                    image = photoEntity.imageEntity,
                )
            )
        }
        return listPhoto.toList()

    }
    override fun mapToEntity(type: List<PhotoEmpty>): List<PhotoEmptyEntity> {
        val listPhotoEntity = ArrayList<PhotoEmptyEntity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                PhotoEmptyEntity(
                    contentEntity = photo.content,
                    imageEntity = photo.image,
                )
            )
        }
        return listPhotoEntity.toList()
    }
}