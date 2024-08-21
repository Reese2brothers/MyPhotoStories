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
                    photoStory4 = Photo4(
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
                    photoStory4Entity =  Photo4Entity(
                        contentEntity = photo.photoStory4.content,
                        imageEntity = photo.photoStory4.image
                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}