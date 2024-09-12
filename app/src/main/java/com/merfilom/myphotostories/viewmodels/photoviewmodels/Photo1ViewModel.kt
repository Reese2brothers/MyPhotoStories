package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.data.dao.photodao.Story1EntityDao
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.usecases.photousecases.DecrementAllStory1IdsUseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete1UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll1UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteStoryByIdUseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll1UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount1UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert1UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo1ViewModel @Inject constructor(
    private val insert1UseCase: Insert1UseCase,
    private val delete1UseCase: Delete1UseCase,
    private val getAll1UseCase: GetAll1UseCase,
    private val deleteAll1UseCase: DeleteAll1UseCase,
    private val getRowCount1UseCase: GetRowCount1UseCase,
    private val deleteStoryByIdUseCase: DeleteStoryByIdUseCase,
    private val decrementAllStory1IdsUseCase: DecrementAllStory1IdsUseCase,
    private  val story1EntityDao : Story1EntityDao
) : ViewModel() {


    private val _photos1 = MutableStateFlow<List<Photo1>>(emptyList())
    val photos1: StateFlow<List<Photo1>> = _photos1

    private val _stories1 = MutableStateFlow<List<Story1>>(emptyList())
    val stories1: StateFlow<List<Story1>> = _stories1

    fun deleteStoryById(id: String) {
        viewModelScope.launch {
            deleteStoryByIdUseCase.storyExecute(id) //.deleteStoryById(id)
        }
    }
    init {
        viewModelScope.launch {
            getAll1UseCase.photoExecute().collect { photoList ->
                _photos1.value = photoList
            }
        }
    loadStories()
    }
    private fun loadStories() {
        viewModelScope.launch {
            getAll1UseCase.storyExecute().collect{
               _stories1.value = it
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
    fun getAll1NewPhoto(): List<Photo1>  {
        var photoList = emptyList<Photo1>()
        viewModelScope.launch {
            getAll1UseCase.photoExecute().collect { list ->
                photoList = list
            }
        }
        return photoList
    }
    fun getAll1NewPhotoStory() {
        viewModelScope.launch {
            getAll1UseCase.storyExecute().collect { storyList ->
                _stories1.value = storyList
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

    suspend fun isTableEmpty(): Boolean {
        return getRowCount1UseCase.photoExecute() == 0
    }
}
