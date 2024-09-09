package com.merfilom.myphotostories.data.dao.photodao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.merfilom.myphotostories.data.models.photomodels.PhotoEmptyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoEmptyEntityDao {
    @Query("SELECT * FROM photoEmptyentity")
    fun getAll(): Flow<List<PhotoEmptyEntity>>
    @Query("DELETE FROM photoEmptyentity")
    suspend fun deleteAll()
    @Insert
    suspend fun insertPhoto(photoEmptyEntity: PhotoEmptyEntity)
    @Query("DELETE FROM photoEmptyentity WHERE imageEntity = :image AND contentEntity = :content")
    suspend fun deletePhoto(image: String, content: String)
    @Query("INSERT INTO photo1entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto1()
    @Query("INSERT INTO photo2entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto2()
    @Query("INSERT INTO photo3entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto3()
    @Query("INSERT INTO photo4entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto4()
    @Query("INSERT INTO photo5entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto5()
    @Query("INSERT INTO photo6entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto6()

    @Query("INSERT INTO photo7entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto7()

    @Query("INSERT INTO photo8entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto8()

    @Query("INSERT INTO photo9entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto9()

    @Query("INSERT INTO photo10entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto10()

    @Query("INSERT INTO photo11entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto11()

    @Query("INSERT INTO photo12entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto12()

    @Query("INSERT INTO photo13entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto13()

    @Query("INSERT INTO photo14entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto14()

    @Query("INSERT INTO photo15entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto15()

    @Query("INSERT INTO photo16entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto16()

    @Query("INSERT INTO photo17entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto17()

    @Query("INSERT INTO photo18entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto18()

    @Query("INSERT INTO photo19entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto19()

    @Query("INSERT INTO photo20entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto20()

    @Query("INSERT INTO photo21entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto21()

    @Query("INSERT INTO photo22entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto22()

    @Query("INSERT INTO photo23entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto23()

    @Query("INSERT INTO photo24entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto24()

    @Query("INSERT INTO photo25entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto25()

    @Query("INSERT INTO photo26entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto26()

    @Query("INSERT INTO photo27entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto27()

    @Query("INSERT INTO photo28entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto28()

    @Query("INSERT INTO photo29entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto29()

    @Query("INSERT INTO photo30entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto30()

    @Query("INSERT INTO photo31entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto31()

    @Query("INSERT INTO photo32entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto32()

    @Query("INSERT INTO photo33entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto33()

    @Query("INSERT INTO photo34entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto34()

    @Query("INSERT INTO photo35entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto35()

    @Query("INSERT INTO photo36entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto36()

    @Query("INSERT INTO photo37entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto37()

    @Query("INSERT INTO photo38entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto38()

    @Query("INSERT INTO photo39entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto39()

    @Query("INSERT INTO photo40entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto40()

    @Query("INSERT INTO photo41entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto41()

    @Query("INSERT INTO photo42entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto42()

    @Query("INSERT INTO photo43entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto43()

    @Query("INSERT INTO photo44entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto44()

    @Query("INSERT INTO photo45entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto45()

    @Query("INSERT INTO photo46entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto46()

    @Query("INSERT INTO photo47entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto47()

    @Query("INSERT INTO photo48entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto48()

    @Query("INSERT INTO photo49entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto49()

    @Query("INSERT INTO photo50entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto50()

    @Query("INSERT INTO photo51entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto51()

    @Query("INSERT INTO photo52entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto52()

    @Query("INSERT INTO photo53entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto53()

    @Query("INSERT INTO photo54entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto54()

    @Query("INSERT INTO photo55entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto55()

    @Query("INSERT INTO photo56entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto56()

    @Query("INSERT INTO photo57entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto57()

    @Query("INSERT INTO photo58entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto58()

    @Query("INSERT INTO photo59entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto59()

    @Query("INSERT INTO photo60entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto60()

    @Query("INSERT INTO photo61entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto61()

    @Query("INSERT INTO photo62entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto62()

    @Query("INSERT INTO photo63entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto63()

    @Query("INSERT INTO photo64entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto64()

    @Query("INSERT INTO photo65entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto65()

    @Query("INSERT INTO photo66entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto66()

    @Query("INSERT INTO photo67entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto67()

    @Query("INSERT INTO photo68entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto68()

    @Query("INSERT INTO photo69entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto69()

    @Query("INSERT INTO photo70entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto70()

    @Query("INSERT INTO photo71entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto71()

    @Query("INSERT INTO photo72entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto72()

    @Query("INSERT INTO photo73entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto73()

    @Query("INSERT INTO photo74entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto74()

    @Query("INSERT INTO photo75entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto75()

    @Query("INSERT INTO photo76entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto76()

    @Query("INSERT INTO photo77entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto77()

    @Query("INSERT INTO photo78entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto78()

    @Query("INSERT INTO photo79entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto79()

    @Query("INSERT INTO photo80entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto80()

    @Query("INSERT INTO photo81entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto81()

    @Query("INSERT INTO photo82entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto82()

    @Query("INSERT INTO photo83entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto83()

    @Query("INSERT INTO photo84entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto84()

    @Query("INSERT INTO photo85entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto85()

    @Query("INSERT INTO photo86entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto86()

    @Query("INSERT INTO photo87entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto87()

    @Query("INSERT INTO photo88entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto88()

    @Query("INSERT INTO photo89entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto89()

    @Query("INSERT INTO photo90entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto90()

    @Query("INSERT INTO photo91entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto91()

    @Query("INSERT INTO photo92entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto92()

    @Query("INSERT INTO photo93entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto93()

    @Query("INSERT INTO photo94entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto94()

    @Query("INSERT INTO photo95entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto95()

    @Query("INSERT INTO photo96entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto96()

    @Query("INSERT INTO photo97entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto97()
    @Query("INSERT INTO photo98entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto98()

    @Query("INSERT INTO photo99entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto99()

    @Query("INSERT INTO photo100entity SELECT * FROM PhotoEmptyEntity")
    suspend fun copyInto100()
}