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
                    image = photoEntity.imageEntity
                   // photoStory1 = Photo1(
//                        content = photoEntity.photoStory1Entity.contentEntity,
//                        image = photoEntity.photoStory1Entity.imageEntity
                   // )
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
                    imageEntity = photo.image
//                    photoStory1Entity =  Photo1Entity(
//                        contentEntity = photo.photoStory1.content,
//                        imageEntity = photo.photoStory1.image
//                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}