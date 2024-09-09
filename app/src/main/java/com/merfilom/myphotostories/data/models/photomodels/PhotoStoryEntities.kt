package com.merfilom.myphotostories.data.models.photomodels

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoryEmptyEntity(
    @Embedded
    val photoStoryEmptyEntity: PhotoEmptyEntity
){
    @PrimaryKey(autoGenerate = true)
    var idStoryEmptyEntity: Int = 0
}
@Entity(tableName = "story1entity")
data class Story1Entity(
    @PrimaryKey(autoGenerate = true)
    var idStory1Entity: Int = 0,
    val idNameEntity : String,
    val imageEntity : String
)
