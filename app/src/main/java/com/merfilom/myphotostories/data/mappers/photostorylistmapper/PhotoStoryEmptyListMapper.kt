package com.merfilom.myphotostories.data.mappers.photostorylistmapper

import com.merfilom.myphotostories.data.mappers.PhotoMapperInterface
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import com.merfilom.myphotostories.data.models.photomodels.StoryEmptyEntity
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty

class PhotoStoryEmptyListMapper: PhotoMapperInterface<List<StoryEmptyEntity>, List<StoryEmpty>> {
    override fun mapFromEntity(type: List<StoryEmptyEntity>): List<StoryEmpty> {
        val listPhoto = ArrayList<StoryEmpty>()

        type.forEach { photoEntity ->
            listPhoto.add(
                StoryEmpty(
                    photoStoryEmpty = PhotoEmpty(
                        content = photoEntity.photoStoryEmptyEntity.contentEntity,
                        image = photoEntity.photoStoryEmptyEntity.imageEntity
                    )
                )
            )
        }
        return listPhoto.toList()
    }
    override fun mapToEntity(type: List<StoryEmpty>): List<StoryEmptyEntity> {
        val listPhotoEntity = ArrayList<StoryEmptyEntity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                StoryEmptyEntity(
                    photoStoryEmptyEntity =  PhotoEmptyEntity(
                        contentEntity = photo.photoStoryEmpty.content,
                        imageEntity = photo.photoStoryEmpty.image
                    )
                )
            )
        }
        return listPhotoEntity.toList()
    }
}