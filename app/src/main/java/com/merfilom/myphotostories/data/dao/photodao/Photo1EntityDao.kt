package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.Photo100Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo2Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo3Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo4Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo5Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo6Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo7Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo8Entity
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
import com.merfilom.myphotostories.data.models.photomodels.Photo9Entity
import kotlinx.coroutines.flow.Flow


@Dao
interface Photo1EntityDao {
    @Query("SELECT * FROM photo1entity")
    fun getAll(): Flow<List<Photo1Entity>>
    @Query("DELETE FROM photo1entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo1Entity: Photo1Entity)
    @Query("DELETE FROM photo1entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("SELECT COUNT(*) FROM photo1entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo2EntityDao {
    @Query("SELECT * FROM photo2entity")
    fun getAll(): Flow<List<Photo2Entity>>
    @Query("DELETE FROM photo2entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo2Entity: Photo2Entity)
    @Query("DELETE FROM photo2entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("SELECT COUNT(*) FROM photo2entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo3EntityDao {
    @Query("SELECT * FROM photo3entity")
    fun getAll(): Flow<List<Photo3Entity>>
    @Query("DELETE FROM photo3entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo3Entity: Photo3Entity)
    @Query("DELETE FROM photo3entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("SELECT COUNT(*) FROM photo3entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo4EntityDao {
    @Query("SELECT * FROM photo4entity")
    fun getAll(): Flow<List<Photo4Entity>>
    @Query("DELETE FROM photo4entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo4Entity: Photo4Entity)
    @Query("DELETE FROM photo4entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("SELECT COUNT(*) FROM photo4entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo5EntityDao {
    @Query("SELECT * FROM photo5entity")
    fun getAll(): Flow<List<Photo5Entity>>
    @Query("DELETE FROM photo5entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo5Entity: Photo5Entity)
    @Query("DELETE FROM photo5entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("SELECT COUNT(*) FROM photo5entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo6EntityDao {
    @Query("SELECT * FROM photo6entity")
    fun getAll(): Flow<List<Photo6Entity>>
    @Query("DELETE FROM photo6entity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photo6Entity: Photo6Entity)
    @Query("DELETE FROM photo6entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("SELECT COUNT(*) FROM photo6entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo7EntityDao {
    @Query("SELECT * FROM photo7entity")
    fun getAll(): Flow<List<Photo7Entity>>

    @Query("DELETE FROM photo7entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo7Entity: Photo7Entity)

    @Query("DELETE FROM photo7entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo7entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo8EntityDao {
    @Query("SELECT * FROM photo8entity")
    fun getAll(): Flow<List<Photo8Entity>>

    @Query("DELETE FROM photo8entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo8Entity: Photo8Entity)

    @Query("DELETE FROM photo8entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo8entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo9EntityDao {
    @Query("SELECT * FROM photo9entity")
    fun getAll(): Flow<List<Photo9Entity>>

    @Query("DELETE FROM photo9entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo9Entity: Photo9Entity)

    @Query("DELETE FROM photo9entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo9entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo10EntityDao {
    @Query("SELECT * FROM photo10entity")
    fun getAll(): Flow<List<Photo10Entity>>

    @Query("DELETE FROM photo10entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo10Entity: Photo10Entity)

    @Query("DELETE FROM photo10entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo10entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo11EntityDao {
    @Query("SELECT * FROM photo11entity")
    fun getAll(): Flow<List<Photo11Entity>>

    @Query("DELETE FROM photo11entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo11Entity: Photo11Entity)

    @Query("DELETE FROM photo11entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo11entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo12EntityDao {
    @Query("SELECT * FROM photo12entity")
    fun getAll(): Flow<List<Photo12Entity>>

    @Query("DELETE FROM photo12entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo12Entity: Photo12Entity)

    @Query("DELETE FROM photo12entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo12entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo13EntityDao {
    @Query("SELECT * FROM photo13entity")
    fun getAll(): Flow<List<Photo13Entity>>

    @Query("DELETE FROM photo13entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo13Entity: Photo13Entity)

    @Query("DELETE FROM photo13entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo13entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo14EntityDao {
    @Query("SELECT * FROM photo14entity")
    fun getAll(): Flow<List<Photo14Entity>>

    @Query("DELETE FROM photo14entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo14Entity: Photo14Entity)

    @Query("DELETE FROM photo14entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo14entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo15EntityDao {
    @Query("SELECT * FROM photo15entity")
    fun getAll(): Flow<List<Photo15Entity>>

    @Query("DELETE FROM photo15entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo15Entity: Photo15Entity)

    @Query("DELETE FROM photo15entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo15entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo16EntityDao {
    @Query("SELECT * FROM photo16entity")
    fun getAll(): Flow<List<Photo16Entity>>

    @Query("DELETE FROM photo16entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo16Entity: Photo16Entity)

    @Query("DELETE FROM photo16entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo16entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo17EntityDao {
    @Query("SELECT * FROM photo17entity")
    fun getAll(): Flow<List<Photo17Entity>>

    @Query("DELETE FROM photo17entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo17Entity: Photo17Entity)

    @Query("DELETE FROM photo17entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo17entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo18EntityDao {
    @Query("SELECT * FROM photo18entity")
    fun getAll(): Flow<List<Photo18Entity>>

    @Query("DELETE FROM photo18entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo18Entity: Photo18Entity)

    @Query("DELETE FROM photo18entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo18entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo19EntityDao {
    @Query("SELECT * FROM photo19entity")
    fun getAll(): Flow<List<Photo19Entity>>

    @Query("DELETE FROM photo19entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo19Entity: Photo19Entity)

    @Query("DELETE FROM photo19entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo19entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo20EntityDao {
    @Query("SELECT * FROM photo20entity")
    fun getAll(): Flow<List<Photo20Entity>>

    @Query("DELETE FROM photo20entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo20Entity: Photo20Entity)

    @Query("DELETE FROM photo20entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo20entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo21EntityDao {
    @Query("SELECT * FROM photo21entity")
    fun getAll(): Flow<List<Photo21Entity>>

    @Query("DELETE FROM photo21entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo21Entity: Photo21Entity)

    @Query("DELETE FROM photo21entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo21entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo22EntityDao {
    @Query("SELECT * FROM photo22entity")
    fun getAll(): Flow<List<Photo22Entity>>

    @Query("DELETE FROM photo22entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo22Entity: Photo22Entity)

    @Query("DELETE FROM photo22entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo22entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo23EntityDao {
    @Query("SELECT * FROM photo23entity")
    fun getAll(): Flow<List<Photo23Entity>>

    @Query("DELETE FROM photo23entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo23Entity: Photo23Entity)

    @Query("DELETE FROM photo23entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo23entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo24EntityDao {
    @Query("SELECT * FROM photo24entity")
    fun getAll(): Flow<List<Photo24Entity>>

    @Query("DELETE FROM photo24entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo24Entity: Photo24Entity)

    @Query("DELETE FROM photo24entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo24entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo25EntityDao {
    @Query("SELECT * FROM photo25entity")
    fun getAll(): Flow<List<Photo25Entity>>

    @Query("DELETE FROM photo25entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo25Entity: Photo25Entity)

    @Query("DELETE FROM photo25entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo25entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo26EntityDao {
    @Query("SELECT * FROM photo26entity")
    fun getAll(): Flow<List<Photo26Entity>>

    @Query("DELETE FROM photo26entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo26Entity: Photo26Entity)

    @Query("DELETE FROM photo26entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo26entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo27EntityDao {
    @Query("SELECT * FROM photo27entity")
    fun getAll(): Flow<List<Photo27Entity>>

    @Query("DELETE FROM photo27entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo27Entity: Photo27Entity)

    @Query("DELETE FROM photo27entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo27entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo28EntityDao {
    @Query("SELECT * FROM photo28entity")
    fun getAll(): Flow<List<Photo28Entity>>

    @Query("DELETE FROM photo28entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo28Entity: Photo28Entity)

    @Query("DELETE FROM photo28entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo28entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo29EntityDao {
    @Query("SELECT * FROM photo29entity")
    fun getAll(): Flow<List<Photo29Entity>>

    @Query("DELETE FROM photo29entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo29Entity: Photo29Entity)

    @Query("DELETE FROM photo29entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo29entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo30EntityDao {
    @Query("SELECT * FROM photo30entity")
    fun getAll(): Flow<List<Photo30Entity>>

    @Query("DELETE FROM photo30entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo30Entity: Photo30Entity)

    @Query("DELETE FROM photo30entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo30entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo31EntityDao {
    @Query("SELECT * FROM photo31entity")
    fun getAll(): Flow<List<Photo31Entity>>

    @Query("DELETE FROM photo31entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo31Entity: Photo31Entity)

    @Query("DELETE FROM photo31entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo31entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo32EntityDao {
    @Query("SELECT * FROM photo32entity")
    fun getAll(): Flow<List<Photo32Entity>>

    @Query("DELETE FROM photo32entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo32Entity: Photo32Entity)

    @Query("DELETE FROM photo32entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo32entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo33EntityDao {
    @Query("SELECT * FROM photo33entity")
    fun getAll(): Flow<List<Photo33Entity>>

    @Query("DELETE FROM photo33entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo33Entity: Photo33Entity)

    @Query("DELETE FROM photo33entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo33entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo34EntityDao {
    @Query("SELECT * FROM photo34entity")
    fun getAll(): Flow<List<Photo34Entity>>

    @Query("DELETE FROM photo34entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo34Entity: Photo34Entity)

    @Query("DELETE FROM photo34entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo34entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo35EntityDao {
    @Query("SELECT * FROM photo35entity")
    fun getAll(): Flow<List<Photo35Entity>>

    @Query("DELETE FROM photo35entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo35Entity: Photo35Entity)

    @Query("DELETE FROM photo35entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo35entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo36EntityDao {
    @Query("SELECT * FROM photo36entity")
    fun getAll(): Flow<List<Photo36Entity>>

    @Query("DELETE FROM photo36entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo36Entity: Photo36Entity)

    @Query("DELETE FROM photo36entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo36entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo37EntityDao {
    @Query("SELECT * FROM photo37entity")
    fun getAll(): Flow<List<Photo37Entity>>

    @Query("DELETE FROM photo37entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo37Entity: Photo37Entity)

    @Query("DELETE FROM photo37entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo37entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo38EntityDao {
    @Query("SELECT * FROM photo38entity")
    fun getAll(): Flow<List<Photo38Entity>>

    @Query("DELETE FROM photo38entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo38Entity: Photo38Entity)

    @Query("DELETE FROM photo38entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo38entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo39EntityDao {
    @Query("SELECT * FROM photo39entity")
    fun getAll(): Flow<List<Photo39Entity>>

    @Query("DELETE FROM photo39entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo39Entity: Photo39Entity)

    @Query("DELETE FROM photo39entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo39entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo40EntityDao {
    @Query("SELECT * FROM photo40entity")
    fun getAll(): Flow<List<Photo40Entity>>

    @Query("DELETE FROM photo40entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo40Entity: Photo40Entity)

    @Query("DELETE FROM photo40entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo40entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo41EntityDao {
    @Query("SELECT * FROM photo41entity")
    fun getAll(): Flow<List<Photo41Entity>>

    @Query("DELETE FROM photo41entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo41Entity: Photo41Entity)

    @Query("DELETE FROM photo41entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo41entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo42EntityDao {
    @Query("SELECT * FROM photo42entity")
    fun getAll(): Flow<List<Photo42Entity>>

    @Query("DELETE FROM photo42entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo42Entity: Photo42Entity)

    @Query("DELETE FROM photo42entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo42entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo43EntityDao {
    @Query("SELECT * FROM photo43entity")
    fun getAll(): Flow<List<Photo43Entity>>

    @Query("DELETE FROM photo43entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo43Entity: Photo43Entity)

    @Query("DELETE FROM photo43entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo43entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo44EntityDao {
    @Query("SELECT * FROM photo44entity")
    fun getAll(): Flow<List<Photo44Entity>>

    @Query("DELETE FROM photo44entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo44Entity: Photo44Entity)

    @Query("DELETE FROM photo44entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo44entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo45EntityDao {
    @Query("SELECT * FROM photo45entity")
    fun getAll(): Flow<List<Photo45Entity>>

    @Query("DELETE FROM photo45entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo45Entity: Photo45Entity)

    @Query("DELETE FROM photo45entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo45entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo46EntityDao {
    @Query("SELECT * FROM photo46entity")
    fun getAll(): Flow<List<Photo46Entity>>

    @Query("DELETE FROM photo46entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo46Entity: Photo46Entity)

    @Query("DELETE FROM photo46entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo46entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo47EntityDao {
    @Query("SELECT * FROM photo47entity")
    fun getAll(): Flow<List<Photo47Entity>>

    @Query("DELETE FROM photo47entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo47Entity: Photo47Entity)

    @Query("DELETE FROM photo47entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo47entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo48EntityDao {
    @Query("SELECT * FROM photo48entity")
    fun getAll(): Flow<List<Photo48Entity>>

    @Query("DELETE FROM photo48entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo48Entity: Photo48Entity)

    @Query("DELETE FROM photo48entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo48entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo49EntityDao {
    @Query("SELECT * FROM photo49entity")
    fun getAll(): Flow<List<Photo49Entity>>

    @Query("DELETE FROM photo49entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo49Entity: Photo49Entity)

    @Query("DELETE FROM photo49entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo49entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo50EntityDao {
    @Query("SELECT * FROM photo50entity")
    fun getAll(): Flow<List<Photo50Entity>>

    @Query("DELETE FROM photo50entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo50Entity: Photo50Entity)

    @Query("DELETE FROM photo50entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo50entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo51EntityDao {
    @Query("SELECT * FROM photo51entity")
    fun getAll(): Flow<List<Photo51Entity>>

    @Query("DELETE FROM photo51entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo51Entity: Photo51Entity)

    @Query("DELETE FROM photo51entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo51entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo52EntityDao {
    @Query("SELECT * FROM photo52entity")
    fun getAll(): Flow<List<Photo52Entity>>

    @Query("DELETE FROM photo52entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo52Entity: Photo52Entity)

    @Query("DELETE FROM photo52entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo52entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo53EntityDao {
    @Query("SELECT * FROM photo53entity")
    fun getAll(): Flow<List<Photo53Entity>>

    @Query("DELETE FROM photo53entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo53Entity: Photo53Entity)

    @Query("DELETE FROM photo53entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo53entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo54EntityDao {
    @Query("SELECT * FROM photo54entity")
    fun getAll(): Flow<List<Photo54Entity>>

    @Query("DELETE FROM photo54entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo54Entity: Photo54Entity)

    @Query("DELETE FROM photo54entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo54entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo55EntityDao {
    @Query("SELECT * FROM photo55entity")
    fun getAll(): Flow<List<Photo55Entity>>

    @Query("DELETE FROM photo55entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo55Entity: Photo55Entity)

    @Query("DELETE FROM photo55entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo55entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo56EntityDao {
    @Query("SELECT * FROM photo56entity")
    fun getAll(): Flow<List<Photo56Entity>>

    @Query("DELETE FROM photo56entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo56Entity: Photo56Entity)

    @Query("DELETE FROM photo56entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo56entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo57EntityDao {
    @Query("SELECT * FROM photo57entity")
    fun getAll(): Flow<List<Photo57Entity>>

    @Query("DELETE FROM photo57entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo57Entity: Photo57Entity)

    @Query("DELETE FROM photo57entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo57entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo58EntityDao {
    @Query("SELECT * FROM photo58entity")
    fun getAll(): Flow<List<Photo58Entity>>

    @Query("DELETE FROM photo58entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo58Entity: Photo58Entity)

    @Query("DELETE FROM photo58entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo58entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo59EntityDao {
    @Query("SELECT * FROM photo59entity")
    fun getAll(): Flow<List<Photo59Entity>>

    @Query("DELETE FROM photo59entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo59Entity: Photo59Entity)

    @Query("DELETE FROM photo59entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo59entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo60EntityDao {
    @Query("SELECT * FROM photo60entity")
    fun getAll(): Flow<List<Photo60Entity>>

    @Query("DELETE FROM photo60entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo60Entity: Photo60Entity)

    @Query("DELETE FROM photo60entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo60entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo61EntityDao {
    @Query("SELECT * FROM photo61entity")
    fun getAll(): Flow<List<Photo61Entity>>

    @Query("DELETE FROM photo61entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo61Entity: Photo61Entity)

    @Query("DELETE FROM photo61entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo61entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo62EntityDao {
    @Query("SELECT * FROM photo62entity")
    fun getAll(): Flow<List<Photo62Entity>>

    @Query("DELETE FROM photo62entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo62Entity: Photo62Entity)

    @Query("DELETE FROM photo62entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo62entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo63EntityDao {
    @Query("SELECT * FROM photo63entity")
    fun getAll(): Flow<List<Photo63Entity>>

    @Query("DELETE FROM photo63entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo63Entity: Photo63Entity)

    @Query("DELETE FROM photo63entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo63entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo64EntityDao {
    @Query("SELECT * FROM photo64entity")
    fun getAll(): Flow<List<Photo64Entity>>

    @Query("DELETE FROM photo64entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo64Entity: Photo64Entity)

    @Query("DELETE FROM photo64entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo64entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo65EntityDao {
    @Query("SELECT * FROM photo65entity")
    fun getAll(): Flow<List<Photo65Entity>>

    @Query("DELETE FROM photo65entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo65Entity: Photo65Entity)

    @Query("DELETE FROM photo65entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo65entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo66EntityDao {
    @Query("SELECT * FROM photo66entity")
    fun getAll(): Flow<List<Photo66Entity>>

    @Query("DELETE FROM photo66entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo66Entity: Photo66Entity)

    @Query("DELETE FROM photo66entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo66entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo67EntityDao {
    @Query("SELECT * FROM photo67entity")
    fun getAll(): Flow<List<Photo67Entity>>

    @Query("DELETE FROM photo67entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo67Entity: Photo67Entity)

    @Query("DELETE FROM photo67entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo67entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo68EntityDao {
    @Query("SELECT * FROM photo68entity")
    fun getAll(): Flow<List<Photo68Entity>>

    @Query("DELETE FROM photo68entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo68Entity: Photo68Entity)

    @Query("DELETE FROM photo68entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo68entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo69EntityDao {
    @Query("SELECT * FROM photo69entity")
    fun getAll(): Flow<List<Photo69Entity>>

    @Query("DELETE FROM photo69entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo69Entity: Photo69Entity)

    @Query("DELETE FROM photo69entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo69entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo70EntityDao {
    @Query("SELECT * FROM photo70entity")
    fun getAll(): Flow<List<Photo70Entity>>

    @Query("DELETE FROM photo70entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo70Entity: Photo70Entity)

    @Query("DELETE FROM photo70entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo70entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo71EntityDao {
    @Query("SELECT * FROM photo71entity")
    fun getAll(): Flow<List<Photo71Entity>>

    @Query("DELETE FROM photo71entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo71Entity: Photo71Entity)

    @Query("DELETE FROM photo71entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo71entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo72EntityDao {
    @Query("SELECT * FROM photo72entity")
    fun getAll(): Flow<List<Photo72Entity>>

    @Query("DELETE FROM photo72entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo72Entity: Photo72Entity)

    @Query("DELETE FROM photo72entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo72entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo73EntityDao {
    @Query("SELECT * FROM photo73entity")
    fun getAll(): Flow<List<Photo73Entity>>

    @Query("DELETE FROM photo73entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo73Entity: Photo73Entity)

    @Query("DELETE FROM photo73entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo73entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo74EntityDao {
    @Query("SELECT * FROM photo74entity")
    fun getAll(): Flow<List<Photo74Entity>>

    @Query("DELETE FROM photo74entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo74Entity: Photo74Entity)

    @Query("DELETE FROM photo74entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo74entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo75EntityDao {
    @Query("SELECT * FROM photo75entity")
    fun getAll(): Flow<List<Photo75Entity>>

    @Query("DELETE FROM photo75entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo75Entity: Photo75Entity)

    @Query("DELETE FROM photo75entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo75entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo76EntityDao {
    @Query("SELECT * FROM photo76entity")
    fun getAll(): Flow<List<Photo76Entity>>

    @Query("DELETE FROM photo76entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo76Entity: Photo76Entity)

    @Query("DELETE FROM photo76entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo76entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo77EntityDao {
    @Query("SELECT * FROM photo77entity")
    fun getAll(): Flow<List<Photo77Entity>>

    @Query("DELETE FROM photo77entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo77Entity: Photo77Entity)

    @Query("DELETE FROM photo77entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo77entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo78EntityDao {
    @Query("SELECT * FROM photo78entity")
    fun getAll(): Flow<List<Photo78Entity>>

    @Query("DELETE FROM photo78entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo78Entity: Photo78Entity)

    @Query("DELETE FROM photo78entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo78entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo79EntityDao {
    @Query("SELECT * FROM photo79entity")
    fun getAll(): Flow<List<Photo79Entity>>

    @Query("DELETE FROM photo79entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo79Entity: Photo79Entity)

    @Query("DELETE FROM photo79entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo79entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo80EntityDao {
    @Query("SELECT * FROM photo80entity")
    fun getAll(): Flow<List<Photo80Entity>>

    @Query("DELETE FROM photo80entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo80Entity: Photo80Entity)

    @Query("DELETE FROM photo80entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo80entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo81EntityDao {
    @Query("SELECT * FROM photo81entity")
    fun getAll(): Flow<List<Photo81Entity>>

    @Query("DELETE FROM photo81entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo81Entity: Photo81Entity)

    @Query("DELETE FROM photo81entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo81entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo82EntityDao {
    @Query("SELECT * FROM photo82entity")
    fun getAll(): Flow<List<Photo82Entity>>

    @Query("DELETE FROM photo82entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo82Entity: Photo82Entity)

    @Query("DELETE FROM photo82entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo82entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo83EntityDao {
    @Query("SELECT * FROM photo83entity")
    fun getAll(): Flow<List<Photo83Entity>>

    @Query("DELETE FROM photo83entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo83Entity: Photo83Entity)

    @Query("DELETE FROM photo83entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo83entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo84EntityDao {
    @Query("SELECT * FROM photo84entity")
    fun getAll(): Flow<List<Photo84Entity>>

    @Query("DELETE FROM photo84entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo84Entity: Photo84Entity)

    @Query("DELETE FROM photo84entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo84entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo85EntityDao {
    @Query("SELECT * FROM photo85entity")
    fun getAll(): Flow<List<Photo85Entity>>

    @Query("DELETE FROM photo85entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo85Entity: Photo85Entity)

    @Query("DELETE FROM photo85entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo85entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo86EntityDao {
    @Query("SELECT * FROM photo86entity")
    fun getAll(): Flow<List<Photo86Entity>>

    @Query("DELETE FROM photo86entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo86Entity: Photo86Entity)

    @Query("DELETE FROM photo86entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo86entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo87EntityDao {
    @Query("SELECT * FROM photo87entity")
    fun getAll(): Flow<List<Photo87Entity>>

    @Query("DELETE FROM photo87entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo87Entity: Photo87Entity)

    @Query("DELETE FROM photo87entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo87entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo88EntityDao {
    @Query("SELECT * FROM photo88entity")
    fun getAll(): Flow<List<Photo88Entity>>

    @Query("DELETE FROM photo88entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo88Entity: Photo88Entity)

    @Query("DELETE FROM photo88entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo88entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo89EntityDao {
    @Query("SELECT * FROM photo89entity")
    fun getAll(): Flow<List<Photo89Entity>>

    @Query("DELETE FROM photo89entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo89Entity: Photo89Entity)

    @Query("DELETE FROM photo89entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo89entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo90EntityDao {
    @Query("SELECT * FROM photo90entity")
    fun getAll(): Flow<List<Photo90Entity>>

    @Query("DELETE FROM photo90entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo90Entity: Photo90Entity)

    @Query("DELETE FROM photo90entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo90entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo91EntityDao {
    @Query("SELECT * FROM photo91entity")
    fun getAll(): Flow<List<Photo91Entity>>

    @Query("DELETE FROM photo91entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo91Entity: Photo91Entity)

    @Query("DELETE FROM photo91entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo91entity")
    suspend fun getRowCount(): Int
}
@Dao
interface Photo92EntityDao {
    @Query("SELECT * FROM photo92entity")
    fun getAll(): Flow<List<Photo92Entity>>

    @Query("DELETE FROM photo92entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo92Entity: Photo92Entity)

    @Query("DELETE FROM photo92entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo92entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo93EntityDao {
    @Query("SELECT * FROM photo93entity")
    fun getAll(): Flow<List<Photo93Entity>>

    @Query("DELETE FROM photo93entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo93Entity: Photo93Entity)

    @Query("DELETE FROM photo93entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo93entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo94EntityDao {
    @Query("SELECT * FROM photo94entity")
    fun getAll(): Flow<List<Photo94Entity>>

    @Query("DELETE FROM photo94entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo94Entity: Photo94Entity)

    @Query("DELETE FROM photo94entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo94entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo95EntityDao {
    @Query("SELECT * FROM photo95entity")
    fun getAll(): Flow<List<Photo95Entity>>

    @Query("DELETE FROM photo95entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo95Entity: Photo95Entity)

    @Query("DELETE FROM photo95entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo95entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo96EntityDao {
    @Query("SELECT * FROM photo96entity")
    fun getAll(): Flow<List<Photo96Entity>>

    @Query("DELETE FROM photo96entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo96Entity: Photo96Entity)

    @Query("DELETE FROM photo96entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo96entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo97EntityDao {
    @Query("SELECT * FROM photo97entity")
    fun getAll(): Flow<List<Photo97Entity>>

    @Query("DELETE FROM photo97entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo97Entity: Photo97Entity)

    @Query("DELETE FROM photo97entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo97entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo98EntityDao {
    @Query("SELECT * FROM photo98entity")
    fun getAll(): Flow<List<Photo98Entity>>

    @Query("DELETE FROM photo98entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo98Entity: Photo98Entity)

    @Query("DELETE FROM photo98entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo98entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo99EntityDao {
    @Query("SELECT * FROM photo99entity")
    fun getAll(): Flow<List<Photo99Entity>>

    @Query("DELETE FROM photo99entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo99Entity: Photo99Entity)

    @Query("DELETE FROM photo99entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo99entity")
    suspend fun getRowCount(): Int
}

@Dao
interface Photo100EntityDao {
    @Query("SELECT * FROM photo100entity")
    fun getAll(): Flow<List<Photo100Entity>>

    @Query("DELETE FROM photo100entity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertPhoto(photo100Entity: Photo100Entity)

    @Query("DELETE FROM photo100entity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)

    @Query("SELECT COUNT(*) FROM photo100entity")
    suspend fun getRowCount(): Int
}