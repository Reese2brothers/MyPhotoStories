package com.merfilom.myphotostories.di

import com.merfilom.myphotostories.data.dao.photodao.Photo1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo2EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo3EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo4EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo5EntityDao
import com.merfilom.myphotostories.data.dao.photodao.PhotoEmptyEntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.StoryEmptyEntityDao
import com.merfilom.myphotostories.data.repositories.photoimpl.Photo1RepositoryImpl
import com.merfilom.myphotostories.data.repositories.photoimpl.Photo2RepositoryImpl
import com.merfilom.myphotostories.data.repositories.photoimpl.Photo3RepositoryImpl
import com.merfilom.myphotostories.data.repositories.photoimpl.Photo4RepositoryImpl
import com.merfilom.myphotostories.data.repositories.photoimpl.Photo5RepositoryImpl
import com.merfilom.myphotostories.data.repositories.photoimpl.PhotoEmptyRepositoryImpl
import com.merfilom.myphotostories.data.repositories.photostoryimpl.PhotoStory1RepositoryImpl
import com.merfilom.myphotostories.data.repositories.photostoryimpl.PhotoStoryEmptyRepositoryImpl
import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStoryEmptyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providePhotoEmptyRepository(photoEmptyEntityDao: PhotoEmptyEntityDao): PhotoEmptyRepository {
        return  PhotoEmptyRepositoryImpl(photoEmptyEntityDao = photoEmptyEntityDao)
    }
    @Singleton
    @Provides
    fun providePhoto1Repository(photo1EntityDao: Photo1EntityDao): Photo1Repository {
        return  Photo1RepositoryImpl(photo1EntityDao = photo1EntityDao)
    }
    @Singleton
    @Provides
    fun providePhoto2Repository(photo2EntityDao: Photo2EntityDao): Photo2Repository {
        return  Photo2RepositoryImpl(photo2EntityDao = photo2EntityDao)
    }
    @Singleton
    @Provides
    fun providePhoto3Repository(photo3EntityDao: Photo3EntityDao): Photo3Repository {
        return  Photo3RepositoryImpl(photo3EntityDao = photo3EntityDao)
    }
    @Singleton
    @Provides
    fun providePhoto4Repository(photo4EntityDao: Photo4EntityDao): Photo4Repository {
        return  Photo4RepositoryImpl(photo4EntityDao = photo4EntityDao)
    }
    @Singleton
    @Provides
    fun providePhoto5Repository(photo5EntityDao: Photo5EntityDao): Photo5Repository {
        return  Photo5RepositoryImpl(photo5EntityDao = photo5EntityDao)
    }


    @Singleton
    @Provides
    fun providePhotoStoryEmptyRepository(storyEmptyEntityDao: StoryEmptyEntityDao): PhotoStoryEmptyRepository {
        return  PhotoStoryEmptyRepositoryImpl(storyEmptyEntityDao = storyEmptyEntityDao)
    }
    @Singleton
    @Provides
    fun providePhotoStory1Repository(story1EntityDao: Story1EntityDao): PhotoStory1Repository {
        return  PhotoStory1RepositoryImpl(story1EntityDao = story1EntityDao)
    }
}