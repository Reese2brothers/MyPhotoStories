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

@Entity
data class Story2Entity(
    @Embedded
    val photoStory2Entity: Photo2Entity
){
    @PrimaryKey(autoGenerate = true)
    var idStory2Entity: Int = 0
}

@Entity
data class Story3Entity(
    @Embedded
    val photoStory3Entity: Photo3Entity
){
    @PrimaryKey(autoGenerate = true)
    var idStory3Entity: Int = 0
}

@Entity
data class Story4Entity(
    @Embedded
    val photoStory4Entity: Photo4Entity
){
    @PrimaryKey(autoGenerate = true)
    var idStory4Entity: Int = 0
}

@Entity
data class Story5Entity(
    @Embedded
    val photoStory5Entity: Photo5Entity
){
    @PrimaryKey(autoGenerate = true)
    var idStory5Entity: Int = 0
}