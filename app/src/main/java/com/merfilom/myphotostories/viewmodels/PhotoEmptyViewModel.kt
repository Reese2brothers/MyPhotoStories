package com.merfilom.myphotostories.viewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty
import com.merfilom.myphotostories.domain.usecases.CopyIntoUseCase
import com.merfilom.myphotostories.domain.usecases.DeleteAllEmptyUseCase
import com.merfilom.myphotostories.domain.usecases.DeleteEmptyUseCase
import com.merfilom.myphotostories.domain.usecases.GetAllEmptyUseCase
import com.merfilom.myphotostories.domain.usecases.InsertEmptyUseCase
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
                    Toast.makeText(context, "All photos deleted successfully!", Toast.LENGTH_SHORT).show()
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