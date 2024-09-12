package com.merfilom.myphotostories.di

import android.content.Context
import com.merfilom.myphotostories.data.AppDatabase
import com.merfilom.myphotostories.data.dao.photodao.*
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
    fun providePhoto6Dao(roomDatabase: AppDatabase): Photo6EntityDao {
        return roomDatabase.photo6EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto7Dao(roomDatabase: AppDatabase): Photo7EntityDao {
        return roomDatabase.photo7EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto8Dao(roomDatabase: AppDatabase): Photo8EntityDao {
        return roomDatabase.photo8EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto9Dao(roomDatabase: AppDatabase): Photo9EntityDao {
        return roomDatabase.photo9EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto10Dao(roomDatabase: AppDatabase): Photo10EntityDao {
        return roomDatabase.photo10EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto11Dao(roomDatabase: AppDatabase): Photo11EntityDao {
        return roomDatabase.photo11EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto12Dao(roomDatabase: AppDatabase): Photo12EntityDao {
        return roomDatabase.photo12EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto13Dao(roomDatabase: AppDatabase): Photo13EntityDao {
        return roomDatabase.photo13EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto14Dao(roomDatabase: AppDatabase): Photo14EntityDao {
        return roomDatabase.photo14EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto15Dao(roomDatabase: AppDatabase): Photo15EntityDao {
        return roomDatabase.photo15EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto16Dao(roomDatabase: AppDatabase): Photo16EntityDao {
        return roomDatabase.photo16EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto17Dao(roomDatabase: AppDatabase): Photo17EntityDao {
        return roomDatabase.photo17EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto18Dao(roomDatabase: AppDatabase): Photo18EntityDao {
        return roomDatabase.photo18EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto19Dao(roomDatabase: AppDatabase): Photo19EntityDao {
        return roomDatabase.photo19EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto20Dao(roomDatabase: AppDatabase): Photo20EntityDao {
        return roomDatabase.photo20EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto21Dao(roomDatabase: AppDatabase): Photo21EntityDao {
        return roomDatabase.photo21EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto22Dao(roomDatabase: AppDatabase): Photo22EntityDao {
        return roomDatabase.photo22EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto23Dao(roomDatabase: AppDatabase): Photo23EntityDao {
        return roomDatabase.photo23EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto24Dao(roomDatabase: AppDatabase): Photo24EntityDao {
        return roomDatabase.photo24EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto25Dao(roomDatabase: AppDatabase): Photo25EntityDao {
        return roomDatabase.photo25EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto26Dao(roomDatabase: AppDatabase): Photo26EntityDao {
        return roomDatabase.photo26EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto27Dao(roomDatabase: AppDatabase): Photo27EntityDao {
        return roomDatabase.photo27EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto28Dao(roomDatabase: AppDatabase): Photo28EntityDao {
        return roomDatabase.photo28EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto29Dao(roomDatabase: AppDatabase): Photo29EntityDao {
        return roomDatabase.photo29EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto30Dao(roomDatabase: AppDatabase): Photo30EntityDao {
        return roomDatabase.photo30EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto31Dao(roomDatabase: AppDatabase): Photo31EntityDao {
        return roomDatabase.photo31EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto32Dao(roomDatabase: AppDatabase): Photo32EntityDao {
        return roomDatabase.photo32EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto33Dao(roomDatabase: AppDatabase): Photo33EntityDao {
        return roomDatabase.photo33EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto34Dao(roomDatabase: AppDatabase): Photo34EntityDao {
        return roomDatabase.photo34EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto35Dao(roomDatabase: AppDatabase): Photo35EntityDao {
        return roomDatabase.photo35EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto36Dao(roomDatabase: AppDatabase): Photo36EntityDao {
        return roomDatabase.photo36EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto37Dao(roomDatabase: AppDatabase): Photo37EntityDao {
        return roomDatabase.photo37EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto38Dao(roomDatabase: AppDatabase): Photo38EntityDao {
        return roomDatabase.photo38EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto39Dao(roomDatabase: AppDatabase): Photo39EntityDao {
        return roomDatabase.photo39EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto40Dao(roomDatabase: AppDatabase): Photo40EntityDao {
        return roomDatabase.photo40EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto41Dao(roomDatabase: AppDatabase): Photo41EntityDao {
        return roomDatabase.photo41EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto42Dao(roomDatabase: AppDatabase): Photo42EntityDao {
        return roomDatabase.photo42EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto43Dao(roomDatabase: AppDatabase): Photo43EntityDao {
        return roomDatabase.photo43EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto44Dao(roomDatabase: AppDatabase): Photo44EntityDao {
        return roomDatabase.photo44EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto45Dao(roomDatabase: AppDatabase): Photo45EntityDao {
        return roomDatabase.photo45EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto46Dao(roomDatabase: AppDatabase): Photo46EntityDao {
        return roomDatabase.photo46EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto47Dao(roomDatabase: AppDatabase): Photo47EntityDao {
        return roomDatabase.photo47EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto48Dao(roomDatabase: AppDatabase): Photo48EntityDao {
        return roomDatabase.photo48EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto49Dao(roomDatabase: AppDatabase): Photo49EntityDao {
        return roomDatabase.photo49EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto50Dao(roomDatabase: AppDatabase): Photo50EntityDao {
        return roomDatabase.photo50EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto51Dao(roomDatabase: AppDatabase): Photo51EntityDao {
        return roomDatabase.photo51EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto52Dao(roomDatabase: AppDatabase): Photo52EntityDao {
        return roomDatabase.photo52EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto53Dao(roomDatabase: AppDatabase): Photo53EntityDao {
        return roomDatabase.photo53EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto54Dao(roomDatabase: AppDatabase): Photo54EntityDao {
        return roomDatabase.photo54EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto55Dao(roomDatabase: AppDatabase): Photo55EntityDao {
        return roomDatabase.photo55EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto56Dao(roomDatabase: AppDatabase): Photo56EntityDao {
        return roomDatabase.photo56EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto57Dao(roomDatabase: AppDatabase): Photo57EntityDao {
        return roomDatabase.photo57EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto58Dao(roomDatabase: AppDatabase): Photo58EntityDao {
        return roomDatabase.photo58EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto59Dao(roomDatabase: AppDatabase): Photo59EntityDao {
        return roomDatabase.photo59EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto60Dao(roomDatabase: AppDatabase): Photo60EntityDao {
        return roomDatabase.photo60EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto61Dao(roomDatabase: AppDatabase): Photo61EntityDao {
        return roomDatabase.photo61EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto62Dao(roomDatabase: AppDatabase): Photo62EntityDao {
        return roomDatabase.photo62EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto63Dao(roomDatabase: AppDatabase): Photo63EntityDao {
        return roomDatabase.photo63EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto64Dao(roomDatabase: AppDatabase): Photo64EntityDao {
        return roomDatabase.photo64EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto65Dao(roomDatabase: AppDatabase): Photo65EntityDao {
        return roomDatabase.photo65EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto66Dao(roomDatabase: AppDatabase): Photo66EntityDao {
        return roomDatabase.photo66EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto67Dao(roomDatabase: AppDatabase): Photo67EntityDao {
        return roomDatabase.photo67EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto68Dao(roomDatabase: AppDatabase): Photo68EntityDao {
        return roomDatabase.photo68EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto69Dao(roomDatabase: AppDatabase): Photo69EntityDao {
        return roomDatabase.photo69EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto70Dao(roomDatabase: AppDatabase): Photo70EntityDao {
        return roomDatabase.photo70EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto71Dao(roomDatabase: AppDatabase): Photo71EntityDao {
        return roomDatabase.photo71EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto72Dao(roomDatabase: AppDatabase): Photo72EntityDao {
        return roomDatabase.photo72EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto73Dao(roomDatabase: AppDatabase): Photo73EntityDao {
        return roomDatabase.photo73EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto74Dao(roomDatabase: AppDatabase): Photo74EntityDao {
        return roomDatabase.photo74EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto75Dao(roomDatabase: AppDatabase): Photo75EntityDao {
        return roomDatabase.photo75EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto76Dao(roomDatabase: AppDatabase): Photo76EntityDao {
        return roomDatabase.photo76EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto77Dao(roomDatabase: AppDatabase): Photo77EntityDao {
        return roomDatabase.photo77EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto78Dao(roomDatabase: AppDatabase): Photo78EntityDao {
        return roomDatabase.photo78EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto79Dao(roomDatabase: AppDatabase): Photo79EntityDao {
        return roomDatabase.photo79EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto80Dao(roomDatabase: AppDatabase): Photo80EntityDao {
        return roomDatabase.photo80EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto81Dao(roomDatabase: AppDatabase): Photo81EntityDao {
        return roomDatabase.photo81EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto82Dao(roomDatabase: AppDatabase): Photo82EntityDao {
        return roomDatabase.photo82EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto83Dao(roomDatabase: AppDatabase): Photo83EntityDao {
        return roomDatabase.photo83EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto84Dao(roomDatabase: AppDatabase): Photo84EntityDao {
        return roomDatabase.photo84EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto85Dao(roomDatabase: AppDatabase): Photo85EntityDao {
        return roomDatabase.photo85EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto86Dao(roomDatabase: AppDatabase): Photo86EntityDao {
        return roomDatabase.photo86EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto87Dao(roomDatabase: AppDatabase): Photo87EntityDao {
        return roomDatabase.photo87EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto88Dao(roomDatabase: AppDatabase): Photo88EntityDao {
        return roomDatabase.photo88EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto89Dao(roomDatabase: AppDatabase): Photo89EntityDao {
        return roomDatabase.photo89EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto90Dao(roomDatabase: AppDatabase): Photo90EntityDao {
        return roomDatabase.photo90EntityDao()
    }
    @Singleton
    @Provides
    fun providePhoto91Dao(roomDatabase: AppDatabase): Photo91EntityDao {
        return roomDatabase.photo91EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto92Dao(roomDatabase: AppDatabase): Photo92EntityDao {
        return roomDatabase.photo92EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto93Dao(roomDatabase: AppDatabase): Photo93EntityDao {
        return roomDatabase.photo93EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto94Dao(roomDatabase: AppDatabase): Photo94EntityDao {
        return roomDatabase.photo94EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto95Dao(roomDatabase: AppDatabase): Photo95EntityDao {
        return roomDatabase.photo95EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto96Dao(roomDatabase: AppDatabase): Photo96EntityDao {
        return roomDatabase.photo96EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto97Dao(roomDatabase: AppDatabase): Photo97EntityDao {
        return roomDatabase.photo97EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto98Dao(roomDatabase: AppDatabase): Photo98EntityDao {
        return roomDatabase.photo98EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto99Dao(roomDatabase: AppDatabase): Photo99EntityDao {
        return roomDatabase.photo99EntityDao()
    }

    @Singleton
    @Provides
    fun providePhoto100Dao(roomDatabase: AppDatabase): Photo100EntityDao {
        return roomDatabase.photo100EntityDao()
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

}