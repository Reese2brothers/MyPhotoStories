package com.merfilom.myphotostories.data.models.photomodels

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PhotoEmptyEntity(
    val contentEntity: String,
    val imageEntity: String
){
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0
}
@Entity
data class Photo1Entity(
    val contentEntity: String,
    val imageEntity: String
){
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0
}

@Entity
data class Photo2Entity(
    val contentEntity: String,
    val imageEntity: String
)
{
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0
}

@Entity
data class Photo3Entity(
    val contentEntity: String,
    val imageEntity: String
){
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0
}

@Entity
data class Photo4Entity(
    val contentEntity: String,
    val imageEntity: String
){
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0
}

@Entity
data class Photo5Entity(
    val contentEntity: String,
    val imageEntity: String
){
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0
}
