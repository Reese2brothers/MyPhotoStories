package com.merfilom.myphotostories.data.repositories.photoimpl

import com.merfilom.myphotostories.data.dao.photodao.PhotoEmptyEntityDao
import com.merfilom.myphotostories.data.mappers.photolistmapper.PhotoEmptyListMapper
import com.merfilom.myphotostories.data.mappers.photomapper.PhotoEmptyMapper
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoEmptyRepositoryImpl(private val photoEmptyEntityDao: PhotoEmptyEntityDao) : PhotoEmptyRepository {
    private val photoEmptyMapper: PhotoEmptyMapper = PhotoEmptyMapper()
    private val photoEmptyListMapper: PhotoEmptyListMapper = PhotoEmptyListMapper()


    override fun getAll(): Flow<List<PhotoEmpty>> {
        return photoEmptyEntityDao.getAll().map { entities ->
            photoEmptyListMapper.mapFromEntity(entities)
        }
    }

    override suspend fun deleteAll() {
        photoEmptyEntityDao.deleteAll()
    }

    override suspend fun insertPhotoEmpty(photoEmpty: PhotoEmpty) {
        val entity = photoEmptyMapper.mapToEntity(photoEmpty)
        photoEmptyEntityDao.insertPhoto(entity)
    }

    override suspend fun deletePhotoEmpty(photoEmpty: PhotoEmpty) {
        val entity = photoEmptyMapper.mapToEntity(photoEmpty)
        photoEmptyEntityDao.deletePhoto(entity.imageEntity, entity.contentEntity)
    }

    override suspend fun copyInto1() {
        photoEmptyEntityDao.copyInto1()
    }

    override suspend fun copyInto2() {
       photoEmptyEntityDao.copyInto2()
    }

    override suspend fun copyInto3() {
        photoEmptyEntityDao.copyInto3()
    }

    override suspend fun copyInto4() {
        photoEmptyEntityDao.copyInto4()
    }

    override suspend fun copyInto5() {
        photoEmptyEntityDao.copyInto5()
    }
    override suspend fun copyInto6() {
        photoEmptyEntityDao.copyInto6()
    }

    override suspend fun copyInto7() {
        photoEmptyEntityDao.copyInto7()
    }

    override suspend fun copyInto8() {
        photoEmptyEntityDao.copyInto8()
    }

    override suspend fun copyInto9() {
        photoEmptyEntityDao.copyInto9()
    }

    override suspend fun copyInto10() {
        photoEmptyEntityDao.copyInto10()
    }

    override suspend fun copyInto11() {
        photoEmptyEntityDao.copyInto11()
    }

    override suspend fun copyInto12() {
        photoEmptyEntityDao.copyInto12()
    }

    override suspend fun copyInto13() {
        photoEmptyEntityDao.copyInto13()
    }

    override suspend fun copyInto14() {
        photoEmptyEntityDao.copyInto14()
    }

    override suspend fun copyInto15() {
        photoEmptyEntityDao.copyInto15()
    }

    override suspend fun copyInto16() {
        photoEmptyEntityDao.copyInto16()
    }

    override suspend fun copyInto17() {
        photoEmptyEntityDao.copyInto17()
    }

    override suspend fun copyInto18() {
        photoEmptyEntityDao.copyInto18()
    }

    override suspend fun copyInto19() {
        photoEmptyEntityDao.copyInto19()
    }

    override suspend fun copyInto20() {
        photoEmptyEntityDao.copyInto20()
    }

    override suspend fun copyInto21() {
        photoEmptyEntityDao.copyInto21()
    }

    override suspend fun copyInto22() {
        photoEmptyEntityDao.copyInto22()
    }

    override suspend fun copyInto23() {
        photoEmptyEntityDao.copyInto23()
    }

    override suspend fun copyInto24() {
        photoEmptyEntityDao.copyInto24()
    }

    override suspend fun copyInto25() {
        photoEmptyEntityDao.copyInto25()
    }

    override suspend fun copyInto26() {
        photoEmptyEntityDao.copyInto26()
    }

    override suspend fun copyInto27() {
        photoEmptyEntityDao.copyInto27()
    }

    override suspend fun copyInto28() {
        photoEmptyEntityDao.copyInto28()
    }

    override suspend fun copyInto29() {
        photoEmptyEntityDao.copyInto29()
    }

    override suspend fun copyInto30() {
        photoEmptyEntityDao.copyInto30()
    }

    override suspend fun copyInto31() {
        photoEmptyEntityDao.copyInto31()
    }

    override suspend fun copyInto32() {
        photoEmptyEntityDao.copyInto32()
    }

    override suspend fun copyInto33() {
        photoEmptyEntityDao.copyInto33()
    }

    override suspend fun copyInto34() {
        photoEmptyEntityDao.copyInto34()
    }

    override suspend fun copyInto35() {
        photoEmptyEntityDao.copyInto35()
    }

    override suspend fun copyInto36() {
        photoEmptyEntityDao.copyInto36()
    }

    override suspend fun copyInto37() {
        photoEmptyEntityDao.copyInto37()
    }

    override suspend fun copyInto38() {
        photoEmptyEntityDao.copyInto38()
    }

    override suspend fun copyInto39() {
        photoEmptyEntityDao.copyInto39()
    }

    override suspend fun copyInto40() {
        photoEmptyEntityDao.copyInto40()
    }

    override suspend fun copyInto41() {
        photoEmptyEntityDao.copyInto41()
    }

    override suspend fun copyInto42() {
        photoEmptyEntityDao.copyInto42()
    }

    override suspend fun copyInto43() {
        photoEmptyEntityDao.copyInto43()
    }

    override suspend fun copyInto44() {
        photoEmptyEntityDao.copyInto44()
    }

    override suspend fun copyInto45() {
        photoEmptyEntityDao.copyInto45()
    }

    override suspend fun copyInto46() {
        photoEmptyEntityDao.copyInto46()
    }

    override suspend fun copyInto47() {
        photoEmptyEntityDao.copyInto47()
    }

    override suspend fun copyInto48() {
        photoEmptyEntityDao.copyInto48()
    }

    override suspend fun copyInto49() {
        photoEmptyEntityDao.copyInto49()
    }

    override suspend fun copyInto50() {
        photoEmptyEntityDao.copyInto50()
    }

    override suspend fun copyInto51() {
        photoEmptyEntityDao.copyInto51()
    }

    override suspend fun copyInto52() {
        photoEmptyEntityDao.copyInto52()
    }

    override suspend fun copyInto53() {
        photoEmptyEntityDao.copyInto53()
    }

    override suspend fun copyInto54() {
        photoEmptyEntityDao.copyInto54()
    }

    override suspend fun copyInto55() {
        photoEmptyEntityDao.copyInto55()
    }

    override suspend fun copyInto56() {
        photoEmptyEntityDao.copyInto56()
    }

    override suspend fun copyInto57() {
        photoEmptyEntityDao.copyInto57()
    }

    override suspend fun copyInto58() {
        photoEmptyEntityDao.copyInto58()
    }

    override suspend fun copyInto59() {
        photoEmptyEntityDao.copyInto59()
    }

    override suspend fun copyInto60() {
        photoEmptyEntityDao.copyInto60()
    }

    override suspend fun copyInto61() {
        photoEmptyEntityDao.copyInto61()
    }

    override suspend fun copyInto62() {
        photoEmptyEntityDao.copyInto62()
    }

    override suspend fun copyInto63() {
        photoEmptyEntityDao.copyInto63()
    }

    override suspend fun copyInto64() {
        photoEmptyEntityDao.copyInto64()
    }

    override suspend fun copyInto65() {
        photoEmptyEntityDao.copyInto65()
    }

    override suspend fun copyInto66() {
        photoEmptyEntityDao.copyInto66()
    }

    override suspend fun copyInto67() {
        photoEmptyEntityDao.copyInto67()
    }

    override suspend fun copyInto68() {
        photoEmptyEntityDao.copyInto68()
    }

    override suspend fun copyInto69() {
        photoEmptyEntityDao.copyInto69()
    }

    override suspend fun copyInto70() {
        photoEmptyEntityDao.copyInto70()
    }

    override suspend fun copyInto71() {
        photoEmptyEntityDao.copyInto71()
    }

    override suspend fun copyInto72() {
        photoEmptyEntityDao.copyInto72()
    }

    override suspend fun copyInto73() {
        photoEmptyEntityDao.copyInto73()
    }

    override suspend fun copyInto74() {
        photoEmptyEntityDao.copyInto74()
    }

    override suspend fun copyInto75() {
        photoEmptyEntityDao.copyInto75()
    }

    override suspend fun copyInto76() {
        photoEmptyEntityDao.copyInto76()
    }

    override suspend fun copyInto77() {
        photoEmptyEntityDao.copyInto77()
    }

    override suspend fun copyInto78() {
        photoEmptyEntityDao.copyInto78()
    }

    override suspend fun copyInto79() {
        photoEmptyEntityDao.copyInto79()
    }

    override suspend fun copyInto80() {
        photoEmptyEntityDao.copyInto80()
    }

    override suspend fun copyInto81() {
        photoEmptyEntityDao.copyInto81()
    }

    override suspend fun copyInto82() {
        photoEmptyEntityDao.copyInto82()
    }

    override suspend fun copyInto83() {
        photoEmptyEntityDao.copyInto83()
    }

    override suspend fun copyInto84() {
        photoEmptyEntityDao.copyInto84()
    }

    override suspend fun copyInto85() {
        photoEmptyEntityDao.copyInto85()
    }

    override suspend fun copyInto86() {
        photoEmptyEntityDao.copyInto86()
    }

    override suspend fun copyInto87() {
        photoEmptyEntityDao.copyInto87()
    }

    override suspend fun copyInto88() {
        photoEmptyEntityDao.copyInto88()
    }

    override suspend fun copyInto89() {
        photoEmptyEntityDao.copyInto89()
    }

    override suspend fun copyInto90() {
        photoEmptyEntityDao.copyInto90()
    }

    override suspend fun copyInto91() {
        photoEmptyEntityDao.copyInto91()
    }

    override suspend fun copyInto92() {
        photoEmptyEntityDao.copyInto92()
    }

    override suspend fun copyInto93() {
        photoEmptyEntityDao.copyInto93()
    }

    override suspend fun copyInto94() {
        photoEmptyEntityDao.copyInto94()
    }

    override suspend fun copyInto95() {
        photoEmptyEntityDao.copyInto95()
    }

    override suspend fun copyInto96() {
        photoEmptyEntityDao.copyInto96()
    }

    override suspend fun copyInto97() {
        photoEmptyEntityDao.copyInto97()
    }

    override suspend fun copyInto98() {
        photoEmptyEntityDao.copyInto98()
    }

    override suspend fun copyInto99() {
        photoEmptyEntityDao.copyInto99()
    }

    override suspend fun copyInto100() {
        photoEmptyEntityDao.copyInto100()
    }
}