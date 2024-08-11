package com.merfilom.myphotostories.di

import com.merfilom.myphotostories.domain.repositories.photo.Photo1Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo2Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo3Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo4Repository
import com.merfilom.myphotostories.domain.repositories.photo.Photo5Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory1Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory2Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory3Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory4Repository
import com.merfilom.myphotostories.domain.repositories.photostory.PhotoStory5Repository
import com.merfilom.myphotostories.domain.usecases.Delete1UseCase
import com.merfilom.myphotostories.domain.usecases.Delete2UseCase
import com.merfilom.myphotostories.domain.usecases.Delete3UseCase
import com.merfilom.myphotostories.domain.usecases.Delete4UseCase
import com.merfilom.myphotostories.domain.usecases.Delete5UseCase
import com.merfilom.myphotostories.domain.usecases.DeleteAll1UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll1UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll2UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll3UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll4UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll5UseCase
import com.merfilom.myphotostories.domain.usecases.Insert1UseCase
import com.merfilom.myphotostories.domain.usecases.Insert2UseCase
import com.merfilom.myphotostories.domain.usecases.Insert3UseCase
import com.merfilom.myphotostories.domain.usecases.Insert4UseCase
import com.merfilom.myphotostories.domain.usecases.Insert5UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideDelete1UseCase(photo1Repository: Photo1Repository, story1Repository: PhotoStory1Repository): Delete1UseCase {
        return  Delete1UseCase(photo1Repository = photo1Repository, story1Repository = story1Repository)
    }
    @Provides
    fun provideDelete2UseCase(photo2Repository: Photo2Repository, story2Repository: PhotoStory2Repository): Delete2UseCase {
        return  Delete2UseCase(photo2Repository = photo2Repository, story2Repository = story2Repository)
    }
    @Provides
    fun provideDelete3UseCase(photo3Repository: Photo3Repository, story3Repository: PhotoStory3Repository): Delete3UseCase {
        return  Delete3UseCase(photo3Repository = photo3Repository, story3Repository = story3Repository)
    }
    @Provides
    fun provideDelete4UseCase(photo4Repository: Photo4Repository, story4Repository: PhotoStory4Repository): Delete4UseCase {
        return  Delete4UseCase(photo4Repository = photo4Repository, story4Repository = story4Repository)
    }
    @Provides
    fun provideDelete5UseCase(photo5Repository: Photo5Repository, story5Repository: PhotoStory5Repository): Delete5UseCase {
        return  Delete5UseCase(photo5Repository = photo5Repository, story5Repository = story5Repository)
    }



    @Provides
    fun provideDeleteAll1UseCase(photo1Repository: Photo1Repository, story1Repository: PhotoStory1Repository): DeleteAll1UseCase {
        return  DeleteAll1UseCase(photo1Repository = photo1Repository, story1Repository = story1Repository)
    }


    @Provides
    fun provideInsert1UseCase(photo1Repository: Photo1Repository, story1Repository: PhotoStory1Repository): Insert1UseCase {
        return Insert1UseCase(photo1Repository = photo1Repository, story1Repository = story1Repository)
    }
    @Provides
    fun provideInsert2UseCase(photo2Repository: Photo2Repository, story2Repository: PhotoStory2Repository): Insert2UseCase {
        return Insert2UseCase(photo2Repository = photo2Repository, story2Repository = story2Repository)
    }
    @Provides
    fun provideInsert3UseCase(photo3Repository: Photo3Repository, story3Repository: PhotoStory3Repository): Insert3UseCase {
        return Insert3UseCase(photo3Repository = photo3Repository, story3Repository = story3Repository)
    }
    @Provides
    fun provideInsert4UseCase(photo4Repository: Photo4Repository, story4Repository: PhotoStory4Repository): Insert4UseCase {
        return Insert4UseCase(photo4Repository = photo4Repository, story4Repository = story4Repository)
    }
    @Provides
    fun provideInsert5UseCase(photo5Repository: Photo5Repository, story5Repository: PhotoStory5Repository): Insert5UseCase {
        return Insert5UseCase(photo5Repository = photo5Repository, story5Repository = story5Repository)
    }



    @Provides
    fun provideGetAll1UseCase(photo1Repository: Photo1Repository, story1Repository: PhotoStory1Repository): GetAll1UseCase {
        return GetAll1UseCase(photo1Repository = photo1Repository, photoStory1Repository = story1Repository)
    }
    @Provides
    fun provideGetAll2UseCase(photo2Repository: Photo2Repository, story2Repository: PhotoStory2Repository): GetAll2UseCase {
        return GetAll2UseCase(photo2Repository = photo2Repository, photoStory2Repository = story2Repository)
    }
    @Provides
    fun provideGetAll3UseCase(photo3Repository: Photo3Repository, story3Repository: PhotoStory3Repository): GetAll3UseCase {
        return GetAll3UseCase(photo3Repository = photo3Repository, photoStory3Repository = story3Repository)
    }
    @Provides
    fun provideGetAll4UseCase(photo4Repository: Photo4Repository, story4Repository: PhotoStory4Repository): GetAll4UseCase {
        return GetAll4UseCase(photo4Repository = photo4Repository, photoStory4Repository = story4Repository)
    }
    @Provides
    fun provideGetAll5UseCase(photo5Repository: Photo5Repository, story5Repository: PhotoStory5Repository): GetAll5UseCase {
        return GetAll5UseCase(photo5Repository = photo5Repository, photoStory5Repository = story5Repository)
    }
}