package com.merfilom.myphotostories.data.mappers.photostorylistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import com.merfilom.myphotostories.data.models.photomodels.Story2Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.models.photomodels.Story2

class PhotoStory2ListMapper: PhotoMapperInterface<List<Story2Entity>, List<Story2>> {
    override fun mapFromEntity(type: List<Story2Entity>): List<Story2> {
        val listPhoto = ArrayList<Story2>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Story2(
                    photoStory2 = Photo2(
                        content = photoEntity.photoStory2Entity.contentEntity,
                        image = photoEntity.photoStory2Entity.imageEntity
                    )
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Story2>): List<Story2Entity> {
        val listPhotoEntity = ArrayList<Story2Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Story2Entity(
                    photoStory2Entity =  Photo2Entity(
                        contentEntity = photo.photoStory2.content,
                        imageEntity = photo.photoStory2.image
                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}