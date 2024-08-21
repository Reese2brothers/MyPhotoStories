package com.merfilom.myphotostories.di

import android.content.Context
import com.merfilom.myphotostories.data.AppDatabase
import com.merfilom.myphotostories.data.dao.photodao.Photo1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo2EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo3EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo4EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo5EntityDao
import com.merfilom.myphotostories.data.dao.photodao.PhotoEmptyEntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story2EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story3EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story4EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story5EntityDao
import com.merfilom.myphotostories.data.dao.photodao.StoryEmptyEntityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(context = appContext)
    }

    @Singleton
    @Provides
    fun providePhotoEmptyDao(roomDatabase : AppDatabase): PhotoEmptyEntityDao {
        return roomDatabase.photoEmptyEntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto1Dao(roomDatabase : AppDatabase): Photo1EntityDao {
        return roomDatabase.photo1EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto2Dao(roomDatabase : AppDatabase): Photo2EntityDao {
        return roomDatabase.photo2EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto3Dao(roomDatabase : AppDatabase): Photo3EntityDao {
        return roomDatabase.photo3EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto4Dao(roomDatabase : AppDatabase): Photo4EntityDao {
        return roomDatabase.photo4EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto5Dao(roomDatabase : AppDatabase): Photo5EntityDao {
        return roomDatabase.photo5EntityDao()
    }

    @Singleton
    @Provides
    fun provideStoryEmptyDao(roomDatabase : AppDatabase): StoryEmptyEntityDao {
        return roomDatabase.storyEmptyEntityDao()
    }
    @Singleton
    @Provides
    fun provideStory1Dao(roomDatabase : AppDatabase): Story1EntityDao {
        return roomDatabase.story1EntityDao()
    }
    @Singleton
    @Provides
    fun provideStory2Dao(roomDatabase : AppDatabase): Story2EntityDao {
        return roomDatabase.story2EntityDao()
    }
    @Singleton
    @Provides
    fun provideStory3Dao(roomDatabase : AppDatabase): Story3EntityDao {
        return roomDatabase.story3EntityDao()
    }
    @Singleton
    @Provides
    fun provideStory4Dao(roomDatabase : AppDatabase): Story4EntityDao {
        return roomDatabase.story4EntityDao()
    }
    @Singleton
    @Provides
    fun provideStory5Dao(roomDatabase : AppDatabase): Story5EntityDao {
        return roomDatabase.story5EntityDao()
    }
}