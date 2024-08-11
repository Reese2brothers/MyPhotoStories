package com.merfilom.myphotostories.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.merfilom.myphotostories.data.dao.photodao.Photo1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo2EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo3EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo4EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo5EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story2EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story3EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story4EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story5EntityDao
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import com.merfilom.myphotostories.data.models.photomodels.Story1Entity
import com.merfilom.myphotostories.data.models.photomodels.Story2Entity
import com.merfilom.myphotostories.data.models.photomodels.Story3Entity
import com.merfilom.myphotostories.data.models.photomodels.Story4Entity
import com.merfilom.myphotostories.data.models.photomodels.Story5Entity

@Database(entities = [Photo1Entity::class, Photo2Entity::class, Photo3Entity::class, Photo4Entity::class,
    Photo5Entity::class, Story1Entity::class, Story2Entity::class, Story3Entity::class, Story4Entity::class,
    Story5Entity::class,],
    version = 1, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {

    abstract fun photo1EntityDao() : Photo1EntityDao
    abstract fun photo2EntityDao() : Photo2EntityDao
    abstract fun photo3EntityDao() : Photo3EntityDao
    abstract fun photo4EntityDao() : Photo4EntityDao
    abstract fun photo5EntityDao() : Photo5EntityDao
    abstract fun story1EntityDao() : Story1EntityDao
    abstract fun story2EntityDao() : Story2EntityDao
    abstract fun story3EntityDao() : Story3EntityDao
    abstract fun story4EntityDao() : Story4EntityDao
    abstract fun story5EntityDao() : Story5EntityDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}