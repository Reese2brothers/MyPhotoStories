package com.merfilom.myphotostories.data.mappers.photostorylistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import com.merfilom.myphotostories.data.models.photomodels.Story4Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.models.photomodels.Story4

class PhotoStory4ListMapper: PhotoMapperInterface<List<Story4Entity>, List<Story4>> {
    override fun mapFromEntity(type: List<Story4Entity>): List<Story4> {
        val listPhoto = ArrayList<Story4>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Story4(
                    idStory4 = photoEntity.idStory4Entity,
                    photoStory4 = Photo4(
                        id = photoEntity.idStory4Entity,
                        title = photoEntity.photoStory4Entity.titleEntity,
                        content = photoEntity.photoStory4Entity.contentEntity,
                        image = photoEntity.photoStory4Entity.imageEntity
                    )
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Story4>): List<Story4Entity> {
        val listPhotoEntity = ArrayList<Story4Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Story4Entity(
                    idStory4Entity = photo.idStory4,
                    photoStory4Entity =  Photo4Entity(
                        idEntity = photo.idStory4,
                        titleEntity = photo.photoStory4.title,
                        contentEntity = photo.photoStory4.content,
                        imageEntity = photo.photoStory4.image
                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}