package com.merfilom.myphotostories.di

import com.merfilom.myphotostories.data.dao.photodao.*
import com.merfilom.myphotostories.data.repositories.photoimpl.*
import com.merfilom.myphotostories.data.repositories.photostoryimpl.PhotoStory1RepositoryImpl
import com.merfilom.myphotostories.data.repositories.photostoryimpl.PhotoStoryEmptyRepositoryImpl
import com.merfilom.myphotostories.domain.repositories.photo.*
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
    fun providePhoto6Repository(photo6EntityDao: Photo6EntityDao): Photo6Repository {
        return Photo6RepositoryImpl(photo6EntityDao = photo6EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto7Repository(photo7EntityDao: Photo7EntityDao): Photo7Repository {
        return Photo7RepositoryImpl(photo7EntityDao = photo7EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto8Repository(photo8EntityDao: Photo8EntityDao): Photo8Repository {
        return Photo8RepositoryImpl(photo8EntityDao = photo8EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto9Repository(photo9EntityDao: Photo9EntityDao): Photo9Repository {
        return Photo9RepositoryImpl(photo9EntityDao = photo9EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto10Repository(photo10EntityDao: Photo10EntityDao): Photo10Repository {
        return Photo10RepositoryImpl(photo10EntityDao = photo10EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto11Repository(photo11EntityDao: Photo11EntityDao): Photo11Repository {
        return Photo11RepositoryImpl(photo11EntityDao = photo11EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto12Repository(photo12EntityDao: Photo12EntityDao): Photo12Repository {
        return Photo12RepositoryImpl(photo12EntityDao = photo12EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto13Repository(photo13EntityDao: Photo13EntityDao): Photo13Repository {
        return Photo13RepositoryImpl(photo13EntityDao = photo13EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto14Repository(photo14EntityDao: Photo14EntityDao): Photo14Repository {
        return Photo14RepositoryImpl(photo14EntityDao = photo14EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto15Repository(photo15EntityDao: Photo15EntityDao): Photo15Repository {
        return Photo15RepositoryImpl(photo15EntityDao = photo15EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto16Repository(photo16EntityDao: Photo16EntityDao): Photo16Repository {
        return Photo16RepositoryImpl(photo16EntityDao = photo16EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto17Repository(photo17EntityDao: Photo17EntityDao): Photo17Repository {
        return Photo17RepositoryImpl(photo17EntityDao = photo17EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto18Repository(photo18EntityDao: Photo18EntityDao): Photo18Repository {
        return Photo18RepositoryImpl(photo18EntityDao = photo18EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto19Repository(photo19EntityDao: Photo19EntityDao): Photo19Repository {
        return Photo19RepositoryImpl(photo19EntityDao = photo19EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto20Repository(photo20EntityDao: Photo20EntityDao): Photo20Repository {
        return Photo20RepositoryImpl(photo20EntityDao = photo20EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto21Repository(photo21EntityDao: Photo21EntityDao): Photo21Repository {
        return Photo21RepositoryImpl(photo21EntityDao = photo21EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto22Repository(photo22EntityDao: Photo22EntityDao): Photo22Repository {
        return Photo22RepositoryImpl(photo22EntityDao = photo22EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto23Repository(photo23EntityDao: Photo23EntityDao): Photo23Repository {
        return Photo23RepositoryImpl(photo23EntityDao = photo23EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto24Repository(photo24EntityDao: Photo24EntityDao): Photo24Repository {
        return Photo24RepositoryImpl(photo24EntityDao = photo24EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto25Repository(photo25EntityDao: Photo25EntityDao): Photo25Repository {
        return Photo25RepositoryImpl(photo25EntityDao = photo25EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto26Repository(photo26EntityDao: Photo26EntityDao): Photo26Repository {
        return Photo26RepositoryImpl(photo26EntityDao = photo26EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto27Repository(photo27EntityDao: Photo27EntityDao): Photo27Repository {
        return Photo27RepositoryImpl(photo27EntityDao = photo27EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto28Repository(photo28EntityDao: Photo28EntityDao): Photo28Repository {
        return Photo28RepositoryImpl(photo28EntityDao = photo28EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto29Repository(photo29EntityDao: Photo29EntityDao): Photo29Repository {
        return Photo29RepositoryImpl(photo29EntityDao = photo29EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto30Repository(photo30EntityDao: Photo30EntityDao): Photo30Repository {
        return Photo30RepositoryImpl(photo30EntityDao = photo30EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto31Repository(photo31EntityDao: Photo31EntityDao): Photo31Repository {
        return Photo31RepositoryImpl(photo31EntityDao = photo31EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto32Repository(photo32EntityDao: Photo32EntityDao): Photo32Repository {
        return Photo32RepositoryImpl(photo32EntityDao = photo32EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto33Repository(photo33EntityDao: Photo33EntityDao): Photo33Repository {
        return Photo33RepositoryImpl(photo33EntityDao = photo33EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto34Repository(photo34EntityDao: Photo34EntityDao): Photo34Repository {
        return Photo34RepositoryImpl(photo34EntityDao = photo34EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto35Repository(photo35EntityDao: Photo35EntityDao): Photo35Repository {
        return Photo35RepositoryImpl(photo35EntityDao = photo35EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto36Repository(photo36EntityDao: Photo36EntityDao): Photo36Repository {
        return Photo36RepositoryImpl(photo36EntityDao = photo36EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto37Repository(photo37EntityDao: Photo37EntityDao): Photo37Repository {
        return Photo37RepositoryImpl(photo37EntityDao = photo37EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto38Repository(photo38EntityDao: Photo38EntityDao): Photo38Repository {
        return Photo38RepositoryImpl(photo38EntityDao = photo38EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto39Repository(photo39EntityDao: Photo39EntityDao): Photo39Repository {
        return Photo39RepositoryImpl(photo39EntityDao = photo39EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto40Repository(photo40EntityDao: Photo40EntityDao): Photo40Repository {
        return Photo40RepositoryImpl(photo40EntityDao = photo40EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto41Repository(photo41EntityDao: Photo41EntityDao): Photo41Repository {
        return Photo41RepositoryImpl(photo41EntityDao = photo41EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto42Repository(photo42EntityDao: Photo42EntityDao): Photo42Repository {
        return Photo42RepositoryImpl(photo42EntityDao = photo42EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto43Repository(photo43EntityDao: Photo43EntityDao): Photo43Repository {
        return Photo43RepositoryImpl(photo43EntityDao = photo43EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto44Repository(photo44EntityDao: Photo44EntityDao): Photo44Repository {
        return Photo44RepositoryImpl(photo44EntityDao = photo44EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto45Repository(photo45EntityDao: Photo45EntityDao): Photo45Repository {
        return Photo45RepositoryImpl(photo45EntityDao = photo45EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto46Repository(photo46EntityDao: Photo46EntityDao): Photo46Repository {
        return Photo46RepositoryImpl(photo46EntityDao = photo46EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto47Repository(photo47EntityDao: Photo47EntityDao): Photo47Repository {
        return Photo47RepositoryImpl(photo47EntityDao = photo47EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto48Repository(photo48EntityDao: Photo48EntityDao): Photo48Repository {
        return Photo48RepositoryImpl(photo48EntityDao = photo48EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto49Repository(photo49EntityDao: Photo49EntityDao): Photo49Repository {
        return Photo49RepositoryImpl(photo49EntityDao = photo49EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto50Repository(photo50EntityDao: Photo50EntityDao): Photo50Repository {
        return Photo50RepositoryImpl(photo50EntityDao = photo50EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto51Repository(photo51EntityDao: Photo51EntityDao): Photo51Repository {
        return Photo51RepositoryImpl(photo51EntityDao = photo51EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto52Repository(photo52EntityDao: Photo52EntityDao): Photo52Repository {
        return Photo52RepositoryImpl(photo52EntityDao = photo52EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto53Repository(photo53EntityDao: Photo53EntityDao): Photo53Repository {
        return Photo53RepositoryImpl(photo53EntityDao = photo53EntityDao)
    }
    @Singleton
    @Provides
    fun providePhoto54Repository(photo54EntityDao: Photo54EntityDao): Photo54Repository {
        return Photo54RepositoryImpl(photo54EntityDao = photo54EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto55Repository(photo55EntityDao: Photo55EntityDao): Photo55Repository {
        return Photo55RepositoryImpl(photo55EntityDao = photo55EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto56Repository(photo56EntityDao: Photo56EntityDao): Photo56Repository {
        return Photo56RepositoryImpl(photo56EntityDao = photo56EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto57Repository(photo57EntityDao: Photo57EntityDao): Photo57Repository {
        return Photo57RepositoryImpl(photo57EntityDao = photo57EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto58Repository(photo58EntityDao: Photo58EntityDao): Photo58Repository {
        return Photo58RepositoryImpl(photo58EntityDao = photo58EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto59Repository(photo59EntityDao: Photo59EntityDao): Photo59Repository {
        return Photo59RepositoryImpl(photo59EntityDao = photo59EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto60Repository(photo60EntityDao: Photo60EntityDao): Photo60Repository {
        return Photo60RepositoryImpl(photo60EntityDao = photo60EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto61Repository(photo61EntityDao: Photo61EntityDao): Photo61Repository {
        return Photo61RepositoryImpl(photo61EntityDao = photo61EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto62Repository(photo62EntityDao: Photo62EntityDao): Photo62Repository {
        return Photo62RepositoryImpl(photo62EntityDao = photo62EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto63Repository(photo63EntityDao: Photo63EntityDao): Photo63Repository {
        return Photo63RepositoryImpl(photo63EntityDao = photo63EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto64Repository(photo64EntityDao: Photo64EntityDao): Photo64Repository {
        return Photo64RepositoryImpl(photo64EntityDao = photo64EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto65Repository(photo65EntityDao: Photo65EntityDao): Photo65Repository {
        return Photo65RepositoryImpl(photo65EntityDao = photo65EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto66Repository(photo66EntityDao: Photo66EntityDao): Photo66Repository {
        return Photo66RepositoryImpl(photo66EntityDao = photo66EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto67Repository(photo67EntityDao: Photo67EntityDao): Photo67Repository {
        return Photo67RepositoryImpl(photo67EntityDao = photo67EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto68Repository(photo68EntityDao: Photo68EntityDao): Photo68Repository {
        return Photo68RepositoryImpl(photo68EntityDao = photo68EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto69Repository(photo69EntityDao: Photo69EntityDao): Photo69Repository {
        return Photo69RepositoryImpl(photo69EntityDao = photo69EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto70Repository(photo70EntityDao: Photo70EntityDao): Photo70Repository {
        return Photo70RepositoryImpl(photo70EntityDao = photo70EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto71Repository(photo71EntityDao: Photo71EntityDao): Photo71Repository {
        return Photo71RepositoryImpl(photo71EntityDao = photo71EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto72Repository(photo72EntityDao: Photo72EntityDao): Photo72Repository {
        return Photo72RepositoryImpl(photo72EntityDao = photo72EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto73Repository(photo73EntityDao: Photo73EntityDao): Photo73Repository {
        return Photo73RepositoryImpl(photo73EntityDao = photo73EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto74Repository(photo74EntityDao: Photo74EntityDao): Photo74Repository {
        return Photo74RepositoryImpl(photo74EntityDao = photo74EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto75Repository(photo75EntityDao: Photo75EntityDao): Photo75Repository {
        return Photo75RepositoryImpl(photo75EntityDao = photo75EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto76Repository(photo76EntityDao: Photo76EntityDao): Photo76Repository {
        return Photo76RepositoryImpl(photo76EntityDao = photo76EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto77Repository(photo77EntityDao: Photo77EntityDao): Photo77Repository {
        return Photo77RepositoryImpl(photo77EntityDao = photo77EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto78Repository(photo78EntityDao: Photo78EntityDao): Photo78Repository {
        return Photo78RepositoryImpl(photo78EntityDao = photo78EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto79Repository(photo79EntityDao: Photo79EntityDao): Photo79Repository {
        return Photo79RepositoryImpl(photo79EntityDao = photo79EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto80Repository(photo80EntityDao: Photo80EntityDao): Photo80Repository {
        return Photo80RepositoryImpl(photo80EntityDao = photo80EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto81Repository(photo81EntityDao: Photo81EntityDao): Photo81Repository {
        return Photo81RepositoryImpl(photo81EntityDao = photo81EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto82Repository(photo82EntityDao: Photo82EntityDao): Photo82Repository {
        return Photo82RepositoryImpl(photo82EntityDao = photo82EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto83Repository(photo83EntityDao: Photo83EntityDao): Photo83Repository {
        return Photo83RepositoryImpl(photo83EntityDao = photo83EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto84Repository(photo84EntityDao: Photo84EntityDao): Photo84Repository {
        return Photo84RepositoryImpl(photo84EntityDao = photo84EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto85Repository(photo85EntityDao: Photo85EntityDao): Photo85Repository {
        return Photo85RepositoryImpl(photo85EntityDao = photo85EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto86Repository(photo86EntityDao: Photo86EntityDao): Photo86Repository {
        return Photo86RepositoryImpl(photo86EntityDao = photo86EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto87Repository(photo87EntityDao: Photo87EntityDao): Photo87Repository {
        return Photo87RepositoryImpl(photo87EntityDao = photo87EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto88Repository(photo88EntityDao: Photo88EntityDao): Photo88Repository {
        return Photo88RepositoryImpl(photo88EntityDao = photo88EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto89Repository(photo89EntityDao: Photo89EntityDao): Photo89Repository {
        return Photo89RepositoryImpl(photo89EntityDao = photo89EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto90Repository(photo90EntityDao: Photo90EntityDao): Photo90Repository {
        return Photo90RepositoryImpl(photo90EntityDao = photo90EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto91Repository(photo91EntityDao: Photo91EntityDao): Photo91Repository {
        return Photo91RepositoryImpl(photo91EntityDao = photo91EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto92Repository(photo92EntityDao: Photo92EntityDao): Photo92Repository {
        return Photo92RepositoryImpl(photo92EntityDao = photo92EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto93Repository(photo93EntityDao: Photo93EntityDao): Photo93Repository {
        return Photo93RepositoryImpl(photo93EntityDao = photo93EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto94Repository(photo94EntityDao: Photo94EntityDao): Photo94Repository {
        return Photo94RepositoryImpl(photo94EntityDao = photo94EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto95Repository(photo95EntityDao: Photo95EntityDao): Photo95Repository {
        return Photo95RepositoryImpl(photo95EntityDao = photo95EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto96Repository(photo96EntityDao: Photo96EntityDao): Photo96Repository {
        return Photo96RepositoryImpl(photo96EntityDao = photo96EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto97Repository(photo97EntityDao: Photo97EntityDao): Photo97Repository {
        return Photo97RepositoryImpl(photo97EntityDao = photo97EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto98Repository(photo98EntityDao: Photo98EntityDao): Photo98Repository {
        return Photo98RepositoryImpl(photo98EntityDao = photo98EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto99Repository(photo99EntityDao: Photo99EntityDao): Photo99Repository {
        return Photo99RepositoryImpl(photo99EntityDao = photo99EntityDao)
    }

    @Singleton
    @Provides
    fun providePhoto100Repository(photo100EntityDao: Photo100EntityDao): Photo100Repository {
        return Photo100RepositoryImpl(photo100EntityDao = photo100EntityDao)
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