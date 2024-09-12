package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo97
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete97UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll97UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll97UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount97UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert97UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo97ViewModel @Inject constructor(
    private val insert97UseCase: Insert97UseCase,
    private val delete97UseCase: Delete97UseCase,
    private val getAll97UseCase: GetAll97UseCase,
    private val deleteAll97UseCase: DeleteAll97UseCase,
    private val getRowCount97UseCase: GetRowCount97UseCase
) : ViewModel() {


    private val _photos97 = MutableStateFlow<List<Photo97>>(emptyList())
    val photos97: StateFlow<List<Photo97>> = _photos97

    init {
        viewModelScope.launch {
            getAll97UseCase.photoExecute().collect { photoList ->
                _photos97.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo97: Photo97) {
        viewModelScope.launch(Dispatchers.IO) {
            insert97UseCase.photoExecute(photo97)
        }
    }
    fun deleteNewPhoto(photo97 : Photo97, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete97UseCase.photoExecute(photo97)
                _photos97.value = photos97.value.filterNot { it == photo97 }
                val uri = Uri.parse(photo97.image)
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
    fun deleteAll97Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll97UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll97UseCase.photoExecute()
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
        return getRowCount97UseCase.photoExecute() == 0
    }
}