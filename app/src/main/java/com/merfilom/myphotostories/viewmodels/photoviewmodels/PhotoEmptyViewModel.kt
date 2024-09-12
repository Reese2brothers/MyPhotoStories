package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty
import com.merfilom.myphotostories.domain.usecases.photousecases.CopyIntoUseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAllEmptyUseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteEmptyUseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAllEmptyUseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.InsertEmptyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PhotoEmptyViewModel @Inject constructor(
    private val insertEmptyUseCase: InsertEmptyUseCase,
    private val deleteEmptyUseCase: DeleteEmptyUseCase,
    private val getAllEmptyUseCase: GetAllEmptyUseCase,
    private val deleteAllEmptyUseCase: DeleteAllEmptyUseCase,
    private val copyIntoUseCase: CopyIntoUseCase
) : ViewModel() {


    private val _photosEmpty = MutableStateFlow<List<PhotoEmpty>>(emptyList())
    val photosEmpty: StateFlow<List<PhotoEmpty>> = _photosEmpty

    private val _storiesEmpty = MutableStateFlow<List<StoryEmpty>>(emptyList())
    val storiesEmpty: StateFlow<List<StoryEmpty>> = _storiesEmpty

    init {
        viewModelScope.launch {
            getAllEmptyUseCase.photoExecute().collect { photoList ->
                _photosEmpty.value = photoList
            }
        }
    }
    fun insertNewPhoto(photoEmpty: PhotoEmpty) {
        viewModelScope.launch(Dispatchers.IO) {
            insertEmptyUseCase.photoExecute(photoEmpty)
        }
    }

    fun insertNewPhotoStory(storyEmpty: StoryEmpty) {
        viewModelScope.launch(Dispatchers.IO) {
            insertEmptyUseCase.storyExecute(storyEmpty)
        }
    }
    fun deleteNewPhoto(photoEmpty : PhotoEmpty, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                deleteEmptyUseCase.photoExecute(photoEmpty)
                _photosEmpty.value = photosEmpty.value.filterNot { it == photoEmpty }
                val uri = Uri.parse(photoEmpty.image)
                val contentResolver = context.contentResolver
                val rowsDeleted = contentResolver.delete(uri, null, null)
                if (rowsDeleted > 0) {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "File deleted successfully!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "Failed to delete file!", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(context, "Error deleting photo: ${e.message}!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun deleteNewPhotoStory(storyEmpty : StoryEmpty){
        viewModelScope.launch(Dispatchers.IO) {
            deleteEmptyUseCase.storyExecute(storyEmpty)
        }
    }
    fun getAllEmptyNewPhoto(): List<PhotoEmpty>  {
        var photoList = emptyList<PhotoEmpty>()
        viewModelScope.launch {
            getAllEmptyUseCase.photoExecute().collect { list ->
                photoList = list
            }
        }
        return photoList
    }
    fun getAllEmptyNewPhotoStory() {
        viewModelScope.launch {
            getAllEmptyUseCase.storyExecute().collect { storyList ->
                _storiesEmpty.value = storyList
            }
        }
    }
    fun deleteAllEmptyPhoto(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAllEmptyUseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAllEmptyUseCase.photoExecute()
                viewModelScope.launch(Dispatchers.Main) {
                    //Toast.makeText(context, "All photos deleted successfully!", Toast.LENGTH_SHORT).show()
                    Toast.makeText(context, "Successfully!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(context, "Error deleting photos: ${e.message}!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun copyInto1(context: Context){
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute1()
        }
    }
    fun copyInto2(context : Context){
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute2()
        }
    }
    fun copyInto3(context : Context){
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute3()
        }
    }
    fun copyInto4(context : Context){
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute4()
        }
    }
    fun copyInto5(context : Context){
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute5()
        }
    }
    fun copyInto6(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute6()
        }
    }

    fun copyInto7(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute7()
        }
    }

    fun copyInto8(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute8()
        }
    }

    fun copyInto9(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute9()
        }
    }

    fun copyInto10(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute10()
        }
    }
    fun copyInto11(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute11()
        }
    }

    fun copyInto12(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute12()
        }
    }

    fun copyInto13(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute13()
        }
    }

    fun copyInto14(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute14()
        }
    }

    fun copyInto15(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute15()
        }
    }
    fun copyInto16(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute16()
        }
    }

    fun copyInto17(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute17()
        }
    }

    fun copyInto18(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute18()
        }
    }

    fun copyInto19(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute19()
        }
    }

    fun copyInto20(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute20()
        }
    }

    fun copyInto21(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute21()
        }
    }

    fun copyInto22(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute22()
        }
    }

    fun copyInto23(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute23()
        }
    }

    fun copyInto24(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute24()
        }
    }

    fun copyInto25(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute25()
        }
    }
    fun copyInto26(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute26()
        }
    }

    fun copyInto27(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute27()
        }
    }

    fun copyInto28(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute28()
        }
    }

    fun copyInto29(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute29()
        }
    }

    fun copyInto30(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute30()
        }
    }

    fun copyInto31(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute31()
        }
    }

    fun copyInto32(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute32()
        }
    }

    fun copyInto33(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute33()
        }
    }

    fun copyInto34(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute34()
        }
    }

    fun copyInto35(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute35()
        }
    }
    fun copyInto36(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute36()
        }
    }

    fun copyInto37(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute37()
        }
    }

    fun copyInto38(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute38()
        }
    }

    fun copyInto39(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute39()
        }
    }

    fun copyInto40(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute40()
        }
    }

    fun copyInto41(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute41()
        }
    }

    fun copyInto42(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute42()
        }
    }

    fun copyInto43(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute43()
        }
    }

    fun copyInto44(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute44()
        }
    }

    fun copyInto45(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute45()
        }
    }
    fun copyInto46(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute46()
        }
    }

    fun copyInto47(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute47()
        }
    }

    fun copyInto48(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute48()
        }
    }

    fun copyInto49(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute49()
        }
    }

    fun copyInto50(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute50()
        }
    }
    fun copyInto51(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute51()
        }
    }

    fun copyInto52(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute52()
        }
    }

    fun copyInto53(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute53()
        }
    }

    fun copyInto54(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute54()
        }
    }

    fun copyInto55(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute55()
        }
    }

    fun copyInto56(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute56()
        }
    }

    fun copyInto57(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute57()
        }
    }

    fun copyInto58(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute58()
        }
    }

    fun copyInto59(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute59()
        }
    }

    fun copyInto60(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute60()
        }
    }

    fun copyInto61(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute61()
        }
    }

    fun copyInto62(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute62()
        }
    }

    fun copyInto63(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute63()
        }
    }

    fun copyInto64(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute64()
        }
    }

    fun copyInto65(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute65()
        }
    }

    fun copyInto66(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute66()
        }
    }

    fun copyInto67(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute67()
        }
    }

    fun copyInto68(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute68()
        }
    }

    fun copyInto69(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute69()
        }
    }

    fun copyInto70(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute70()
        }
    }

    fun copyInto71(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute71()
        }
    }

    fun copyInto72(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute72()
        }
    }

    fun copyInto73(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute73()
        }
    }

    fun copyInto74(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute74()
        }
    }

    fun copyInto75(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute75()
        }
    }

    fun copyInto76(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute76()
        }
    }

    fun copyInto77(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute77()
        }
    }

    fun copyInto78(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute78()
        }
    }

    fun copyInto79(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute79()
        }
    }

    fun copyInto80(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute80()
        }
    }

    fun copyInto81(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute81()
        }
    }

    fun copyInto82(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute82()
        }
    }

    fun copyInto83(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute83()
        }
    }

    fun copyInto84(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute84()
        }
    }

    fun copyInto85(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute85()
        }
    }

    fun copyInto86(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute86()
        }
    }

    fun copyInto87(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute87()
        }
    }
    fun copyInto88(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute88()
        }
    }

    fun copyInto89(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute89()
        }
    }

    fun copyInto90(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute90()
        }
    }

    fun copyInto91(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute91()
        }
    }

    fun copyInto92(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute92()
        }
    }

    fun copyInto93(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute93()
        }
    }

    fun copyInto94(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute94()
        }
    }

    fun copyInto95(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute95()
        }
    }

    fun copyInto96(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute96()
        }
    }

    fun copyInto97(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute97()
        }
    }

    fun copyInto98(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute98()
        }
    }

    fun copyInto99(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute99()
        }
    }

    fun copyInto100(context: Context) {
        viewModelScope.launch {
            val imageUris = photosEmpty.value.map { it.image.toUri() }
            saveTransferedImagesToFile(context, imageUris)
            copyIntoUseCase.photoExecute100()
        }
    }

    fun saveTransferedImagesToFile(context: Context, imageUris: List<Uri>): List<Uri> {
        val storageDir = File(context.getExternalFilesDir(null), "transfered_images")
        if (!storageDir.exists()) {
            storageDir.mkdirs()
        }

        return imageUris.map { uri ->
            val inputStream = context.contentResolver.openInputStream(uri)
            val fileName = uri.lastPathSegment ?: "JPEG_${SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())}.jpg"
            val photoFile = File(storageDir, fileName)

            if (!photoFile.exists()) {
                val outputStream = FileOutputStream(photoFile)
                inputStream?.copyTo(outputStream)
                inputStream?.close()
                outputStream.close()
            }

            FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", photoFile)
        }
    }
}