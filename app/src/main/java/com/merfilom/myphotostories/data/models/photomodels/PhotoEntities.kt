package com.merfilom.myphotostories.data.models.photomodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photo1Entity(
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0,
    val titleEntity: String,
    val contentEntity: String,
    val imageEntity: String
)

@Entity
data class Photo2Entity(
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0,
    val titleEntity: String,
    val contentEntity: String,
    val imageEntity: String
)

@Entity
data class Photo3Entity(
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0,
    val titleEntity: String,
    val contentEntity: String,
    val imageEntity: String
)

@Entity
data class Photo4Entity(
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0,
    val titleEntity: String,
    val contentEntity: String,
    val imageEntity: String
)

@Entity
data class Photo5Entity(
    @PrimaryKey(autoGenerate = true)
    var idEntity: Int = 0,
    val titleEntity: String,
    val contentEntity: String,
    val imageEntity: String
)
