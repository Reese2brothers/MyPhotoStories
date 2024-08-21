package com.merfilom.myphotostories.data.mappers.photostorylistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import com.merfilom.myphotostories.data.models.photomodels.Story5Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.Story5

class PhotoStory5ListMapper: PhotoMapperInterface<List<Story5Entity>, List<Story5>> {
    override fun mapFromEntity(type: List<Story5Entity>): List<Story5> {
        val listPhoto = ArrayList<Story5>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Story5(
                    photoStory5 = Photo5(
                        content = photoEntity.photoStory5Entity.contentEntity,
                        image = photoEntity.photoStory5Entity.imageEntity
                    )
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<Story5>): List<Story5Entity> {
        val listPhotoEntity = ArrayList<Story5Entity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                Story5Entity(
                    photoStory5Entity =  Photo5Entity(
                        contentEntity = photo.photoStory5.content,
                        imageEntity = photo.photoStory5.image
                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}