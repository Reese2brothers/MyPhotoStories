package com.merfilom.myphotostories.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Table1Entity(
   val description : String,
   val image : String
)
{
    @PrimaryKey var id: Int = 0
}
