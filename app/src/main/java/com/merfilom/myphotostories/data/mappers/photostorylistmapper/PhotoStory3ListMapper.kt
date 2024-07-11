package com.merfilom.myphotostories.data.mappers.photostorylistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import com.merfilom.myphotostories.data.models.photomodels.Story3Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.models.photomodels.Story3

class PhotoStory3ListMapper: PhotoMapperInterface<List<Story3Entity>, List<Story3>> {
    override fun mapFromEntity(type: List<Story3Entity>): List<Story3> {
        val listPhoto = ArrayList<Story3>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Story3(
                    idStory3 = photoEntity.idStory3Entity,
                    photoStory3 = Photo3(
                        id = photoEntity.idStory3Entity,
                        title = photoEntity.photoStory3Entity.titleEntity,
                        content = photoEntity.photoStory3Entity.contentEntity,
                        image = photoEntity.photoStory3Entity.imageEntity
                    )
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Story3>): List<Story3Entity> {
        val listPhotoEntity = ArrayList<Story3Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Story3Entity(
                    idStory3Entity = photo.idStory3,
                    photoStory3Entity =  Photo3Entity(
                        idEntity = photo.idStory3,
                        titleEntity = photo.photoStory3.title,
                        contentEntity = photo.photoStory3.content,
                        imageEntity = photo.photoStory3.image
                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}