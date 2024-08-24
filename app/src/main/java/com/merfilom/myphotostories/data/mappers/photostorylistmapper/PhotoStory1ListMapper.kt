package com.merfilom.myphotostories.data.mappers.photostorylistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.data.models.photomodels.Story1Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1

class PhotoStory1ListMapper: PhotoMapperInterface<List<Story1Entity>, List<Story1>> {
    override fun mapFromEntity(type: List<Story1Entity>): List<Story1> {
        val listPhoto = ArrayList<Story1>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Story1(
                    //id = photoEntity.idStory1Entity,
                    image = photoEntity.imageEntity
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Story1>): List<Story1Entity> {
        val listPhotoEntity = ArrayList<Story1Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Story1Entity(
                    //idStory1Entity = photo.id,
                    imageEntity = photo.image
                )
            )
        }
        return listPhotoEntity.toList()
    }
}