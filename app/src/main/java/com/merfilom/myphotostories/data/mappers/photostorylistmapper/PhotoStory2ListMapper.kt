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
                    idStory2 = photoEntity.idStory2Entity,
                    photoStory2 = Photo2(
                        id = photoEntity.idStory2Entity,
                        title = photoEntity.photoStory2Entity.titleEntity,
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
                    idStory2Entity = photo.idStory2,
                    photoStory2Entity =  Photo2Entity(
                        idEntity = photo.idStory2,
                        titleEntity = photo.photoStory2.title,
                        contentEntity = photo.photoStory2.content,
                        imageEntity = photo.photoStory2.image
                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}