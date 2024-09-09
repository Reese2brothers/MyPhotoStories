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
import com.merfilom.myphotostories.data.dao.photodao.Photo6EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo7EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo8EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo9EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo10EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo11EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo12EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo13EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo14EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo15EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo16EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo17EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo18EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo19EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo20EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo21EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo22EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo23EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo24EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo25EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo26EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo27EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo28EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo29EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo30EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo31EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo32EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo33EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo34EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo35EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo36EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo37EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo38EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo39EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo40EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo41EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo42EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo43EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo44EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo45EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo46EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo47EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo48EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo49EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo50EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo51EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo52EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo53EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo54EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo55EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo56EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo57EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo58EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo59EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo60EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo61EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo62EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo63EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo64EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo65EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo66EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo67EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo68EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo69EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo70EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo71EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo72EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo73EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo74EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo75EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo76EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo77EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo78EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo79EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo80EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo81EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo82EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo83EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo84EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo85EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo86EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo87EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo88EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo89EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo90EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo91EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo92EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo93EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo94EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo95EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo96EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo97EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo98EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo99EntityDao
import com.merfilom.myphotostories.data.dao.photodao.Photo100EntityDao

import com.merfilom.myphotostories.data.dao.photodao.PhotoEmptyEntityDao
import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.data.dao.photodao.StoryEmptyEntityDao
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo6Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo7Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo8Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo9Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo10Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo11Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo12Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo13Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo14Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo15Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo16Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo17Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo18Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo19Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo20Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo21Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo22Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo23Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo24Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo25Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo26Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo27Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo28Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo29Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo30Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo31Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo32Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo33Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo34Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo35Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo36Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo37Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo38Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo39Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo40Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo41Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo42Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo43Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo44Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo45Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo46Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo47Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo48Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo49Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo50Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo51Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo52Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo53Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo54Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo55Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo56Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo57Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo58Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo59Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo60Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo61Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo62Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo63Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo64Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo65Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo66Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo67Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo68Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo69Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo70Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo71Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo72Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo73Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo74Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo75Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo76Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo77Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo78Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo79Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo80Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo81Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo82Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo83Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo84Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo85Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo86Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo87Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo88Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo89Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo90Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo91Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo92Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo93Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo94Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo95Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo96Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo97Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo98Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo99Entity
import com.merfilom.myphotostories.data.models.photomodels.Photo100Entity
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import com.merfilom.myphotostories.data.models.photomodels.Story1Entity
import com.merfilom.myphotostories.data.models.photomodels.StoryEmptyEntity

@Database(entities = [
    PhotoEmptyEntity::class, Photo1Entity::class, Photo2Entity::class, Photo3Entity::class, Photo4Entity::class, Photo5Entity::class,
    Photo6Entity::class, Photo7Entity::class, Photo8Entity::class, Photo9Entity::class, Photo10Entity::class,
    Photo11Entity::class, Photo12Entity::class, Photo13Entity::class, Photo14Entity::class, Photo15Entity::class,
    Photo16Entity::class, Photo17Entity::class, Photo18Entity::class, Photo19Entity::class, Photo20Entity::class,
    Photo21Entity::class, Photo22Entity::class, Photo23Entity::class, Photo24Entity::class, Photo25Entity::class,
    Photo26Entity::class, Photo27Entity::class, Photo28Entity::class, Photo29Entity::class, Photo30Entity::class,
    Photo31Entity::class, Photo32Entity::class, Photo33Entity::class, Photo34Entity::class, Photo35Entity::class,
    Photo36Entity::class, Photo37Entity::class, Photo38Entity::class, Photo39Entity::class, Photo40Entity::class,
    Photo41Entity::class, Photo42Entity::class, Photo43Entity::class, Photo44Entity::class, Photo45Entity::class,
    Photo46Entity::class, Photo47Entity::class, Photo48Entity::class, Photo49Entity::class, Photo50Entity::class,
    Photo51Entity::class, Photo52Entity::class, Photo53Entity::class, Photo54Entity::class, Photo55Entity::class,
    Photo56Entity::class, Photo57Entity::class, Photo58Entity::class, Photo59Entity::class, Photo60Entity::class,
    Photo61Entity::class, Photo62Entity::class, Photo63Entity::class, Photo64Entity::class, Photo65Entity::class,
    Photo66Entity::class, Photo67Entity::class, Photo68Entity::class, Photo69Entity::class, Photo70Entity::class,
    Photo71Entity::class, Photo72Entity::class, Photo73Entity::class, Photo74Entity::class, Photo75Entity::class,
    Photo76Entity::class, Photo77Entity::class, Photo78Entity::class, Photo79Entity::class, Photo80Entity::class,
    Photo81Entity::class, Photo82Entity::class, Photo83Entity::class, Photo84Entity::class, Photo85Entity::class,
    Photo86Entity::class, Photo87Entity::class, Photo88Entity::class, Photo89Entity::class, Photo90Entity::class,
    Photo91Entity::class, Photo92Entity::class, Photo93Entity::class, Photo94Entity::class, Photo95Entity::class,
    Photo96Entity::class, Photo97Entity::class, Photo98Entity::class, Photo99Entity::class, Photo100Entity::class,
            StoryEmptyEntity::class, Story1Entity::class,],
    version = 1, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {

    abstract fun photoEmptyEntityDao() : PhotoEmptyEntityDao
    abstract fun photo1EntityDao() : Photo1EntityDao
    abstract fun photo2EntityDao() : Photo2EntityDao
    abstract fun photo3EntityDao() : Photo3EntityDao
    abstract fun photo4EntityDao() : Photo4EntityDao
    abstract fun photo5EntityDao() : Photo5EntityDao
    abstract fun photo6EntityDao(): Photo6EntityDao
    abstract fun photo7EntityDao(): Photo7EntityDao
    abstract fun photo8EntityDao(): Photo8EntityDao
    abstract fun photo9EntityDao(): Photo9EntityDao
    abstract fun photo10EntityDao(): Photo10EntityDao
    abstract fun photo11EntityDao(): Photo11EntityDao
    abstract fun photo12EntityDao(): Photo12EntityDao
    abstract fun photo13EntityDao(): Photo13EntityDao
    abstract fun photo14EntityDao(): Photo14EntityDao
    abstract fun photo15EntityDao(): Photo15EntityDao
    abstract fun photo16EntityDao(): Photo16EntityDao
    abstract fun photo17EntityDao(): Photo17EntityDao
    abstract fun photo18EntityDao(): Photo18EntityDao
    abstract fun photo19EntityDao(): Photo19EntityDao
    abstract fun photo20EntityDao(): Photo20EntityDao
    abstract fun photo21EntityDao(): Photo21EntityDao
    abstract fun photo22EntityDao(): Photo22EntityDao
    abstract fun photo23EntityDao(): Photo23EntityDao
    abstract fun photo24EntityDao(): Photo24EntityDao
    abstract fun photo25EntityDao(): Photo25EntityDao
    abstract fun photo26EntityDao(): Photo26EntityDao
    abstract fun photo27EntityDao(): Photo27EntityDao
    abstract fun photo28EntityDao(): Photo28EntityDao
    abstract fun photo29EntityDao(): Photo29EntityDao
    abstract fun photo30EntityDao(): Photo30EntityDao
    abstract fun photo31EntityDao(): Photo31EntityDao
    abstract fun photo32EntityDao(): Photo32EntityDao
    abstract fun photo33EntityDao(): Photo33EntityDao
    abstract fun photo34EntityDao(): Photo34EntityDao
    abstract fun photo35EntityDao(): Photo35EntityDao
    abstract fun photo36EntityDao(): Photo36EntityDao
    abstract fun photo37EntityDao(): Photo37EntityDao
    abstract fun photo38EntityDao(): Photo38EntityDao
    abstract fun photo39EntityDao(): Photo39EntityDao
    abstract fun photo40EntityDao(): Photo40EntityDao
    abstract fun photo41EntityDao(): Photo41EntityDao
    abstract fun photo42EntityDao(): Photo42EntityDao
    abstract fun photo43EntityDao(): Photo43EntityDao
    abstract fun photo44EntityDao(): Photo44EntityDao
    abstract fun photo45EntityDao(): Photo45EntityDao
    abstract fun photo46EntityDao(): Photo46EntityDao
    abstract fun photo47EntityDao(): Photo47EntityDao
    abstract fun photo48EntityDao(): Photo48EntityDao
    abstract fun photo49EntityDao(): Photo49EntityDao
    abstract fun photo50EntityDao(): Photo50EntityDao
    abstract fun photo51EntityDao(): Photo51EntityDao
    abstract fun photo52EntityDao(): Photo52EntityDao
    abstract fun photo53EntityDao(): Photo53EntityDao
    abstract fun photo54EntityDao(): Photo54EntityDao
    abstract fun photo55EntityDao(): Photo55EntityDao
    abstract fun photo56EntityDao(): Photo56EntityDao
    abstract fun photo57EntityDao(): Photo57EntityDao
    abstract fun photo58EntityDao(): Photo58EntityDao
    abstract fun photo59EntityDao(): Photo59EntityDao
    abstract fun photo60EntityDao(): Photo60EntityDao
    abstract fun photo61EntityDao(): Photo61EntityDao
    abstract fun photo62EntityDao(): Photo62EntityDao
    abstract fun photo63EntityDao(): Photo63EntityDao
    abstract fun photo64EntityDao(): Photo64EntityDao
    abstract fun photo65EntityDao(): Photo65EntityDao
    abstract fun photo66EntityDao(): Photo66EntityDao
    abstract fun photo67EntityDao(): Photo67EntityDao
    abstract fun photo68EntityDao(): Photo68EntityDao
    abstract fun photo69EntityDao(): Photo69EntityDao
    abstract fun photo70EntityDao(): Photo70EntityDao
    abstract fun photo71EntityDao(): Photo71EntityDao
    abstract fun photo72EntityDao(): Photo72EntityDao
    abstract fun photo73EntityDao(): Photo73EntityDao
    abstract fun photo74EntityDao(): Photo74EntityDao
    abstract fun photo75EntityDao(): Photo75EntityDao
    abstract fun photo76EntityDao(): Photo76EntityDao
    abstract fun photo77EntityDao(): Photo77EntityDao
    abstract fun photo78EntityDao(): Photo78EntityDao
    abstract fun photo79EntityDao(): Photo79EntityDao
    abstract fun photo80EntityDao(): Photo80EntityDao
    abstract fun photo81EntityDao(): Photo81EntityDao
    abstract fun photo82EntityDao(): Photo82EntityDao
    abstract fun photo83EntityDao(): Photo83EntityDao
    abstract fun photo84EntityDao(): Photo84EntityDao
    abstract fun photo85EntityDao(): Photo85EntityDao
    abstract fun photo86EntityDao(): Photo86EntityDao
    abstract fun photo87EntityDao(): Photo87EntityDao
    abstract fun photo88EntityDao(): Photo88EntityDao
    abstract fun photo89EntityDao(): Photo89EntityDao
    abstract fun photo90EntityDao(): Photo90EntityDao
    abstract fun photo91EntityDao(): Photo91EntityDao
    abstract fun photo92EntityDao(): Photo92EntityDao
    abstract fun photo93EntityDao(): Photo93EntityDao
    abstract fun photo94EntityDao(): Photo94EntityDao
    abstract fun photo95EntityDao(): Photo95EntityDao
    abstract fun photo96EntityDao(): Photo96EntityDao
    abstract fun photo97EntityDao(): Photo97EntityDao
    abstract fun photo98EntityDao(): Photo98EntityDao
    abstract fun photo99EntityDao(): Photo99EntityDao
    abstract fun photo100EntityDao(): Photo100EntityDao
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