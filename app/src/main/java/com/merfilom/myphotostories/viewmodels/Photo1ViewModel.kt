package com.merfilom.myphotostories.viewmodels

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.net.toUri
import androidx.documentfile.provider.DocumentFile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.data.dao.photodao.Photo1EntityDao
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.usecases.Delete1UseCase
import com.merfilom.myphotostories.domain.usecases.DeleteAll1UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll1UseCase
import com.merfilom.myphotostories.domain.usecases.Insert1UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

@HiltViewModel
class Photo1ViewModel @Inject constructor(
    private val insert1UseCase: Insert1UseCase,
    private val delete1UseCase: Delete1UseCase,
    private val getAll1UseCase: GetAll1UseCase,
    private val deleteAll1UseCase: DeleteAll1UseCase
) : ViewModel() {


    private val _photos1 = MutableStateFlow<List<Photo1>>(emptyList())
    val photos1: StateFlow<List<Photo1>> = _photos1

    private val _stories = MutableStateFlow<List<Story1>>(emptyList())
    val stories: StateFlow<List<Story1>> = _stories

    init {
        viewModelScope.launch {
            getAll1UseCase.photoExecute().collect { photoList ->
                _photos1.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo1: Photo1) {
        viewModelScope.launch(Dispatchers.IO) {
            insert1UseCase.photoExecute(photo1)
        }
    }

    fun insertNewPhotoStory(story1: Story1) {
        viewModelScope.launch(Dispatchers.IO) {
            insert1UseCase.storyExecute(story1)
        }
    }
    fun deleteNewPhoto(photo1 : Photo1, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete1UseCase.photoExecute(photo1)
                _photos1.value = photos1.value.filterNot { it == photo1 }
                val uri = Uri.parse(photo1.image)
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
    fun deleteNewPhotoStory(story1 : Story1){
        viewModelScope.launch(Dispatchers.IO) {
            delete1UseCase.storyExecute(story1)
        }
    }
    fun getAll1NewPhoto()  {
        viewModelScope.launch {
            getAll1UseCase.photoExecute().collect { photoList ->
                _photos1.value = photoList
            }
        }
    }
    fun getAll1NewPhotoStory() {
        viewModelScope.launch {
            getAll1UseCase.storyExecute().collect { storyList ->
                _stories.value = storyList
            }
        }
    }
    fun deleteAll1Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll1UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll1UseCase.photoExecute()
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
}
