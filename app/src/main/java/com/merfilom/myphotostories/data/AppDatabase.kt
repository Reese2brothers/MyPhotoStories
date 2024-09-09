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
import com.merfilom.myphotostories.data.dao.photodao.PhotoEmptyEntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.StoryEmptyEntityDao
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import com.merfilom.myphotostories.data.models.photomodels.Story1Entity
import com.merfilom.myphotostories.data.models.photomodels.StoryEmptyEntity

@Database(entities = [
    PhotoEmptyEntity::class,Photo1Entity::class, Photo2Entity::class, Photo3Entity::class, Photo4Entity::class,
    Photo5Entity::class, StoryEmptyEntity::class, Story1Entity::class],
    version = 1, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {

    abstract fun photoEmptyEntityDao() : PhotoEmptyEntityDao
    abstract fun photo1EntityDao() : Photo1EntityDao
    abstract fun photo2EntityDao() : Photo2EntityDao
    abstract fun photo3EntityDao() : Photo3EntityDao
    abstract fun photo4EntityDao() : Photo4EntityDao
    abstract fun photo5EntityDao() : Photo5EntityDao
    abstract fun storyEmptyEntityDao() : StoryEmptyEntityDao
    abstract fun story1EntityDao() : Story1EntityDao

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