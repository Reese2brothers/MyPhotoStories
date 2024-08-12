package com.merfilom.myphotostories.data.models.photomodels

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Story1Entity(
    @Embedded
    val photoStory1Entity: Photo1Entity
){
    @PrimaryKey(autoGenerate = true)
    var idStory1Entity: Int = 0
}

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
    @PrimaryKey(autoGenerate = true)
    var idStory3Entity: Int = 0,
    @Embedded
    val photoStory3Entity: Photo3Entity
)

@Entity
data class Story4Entity(
    @PrimaryKey(autoGenerate = true)
    var idStory4Entity: Int = 0,
    @Embedded
    val photoStory4Entity: Photo4Entity
)

@Entity
data class Story5Entity(
    @PrimaryKey(autoGenerate = true)
    var idStory5Entity: Int = 0,
    @Embedded
    val photoStory5Entity: Photo5Entity
)