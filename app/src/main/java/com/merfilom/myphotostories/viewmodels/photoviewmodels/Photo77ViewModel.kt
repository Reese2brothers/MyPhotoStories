package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo77
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete77UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll77UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll77UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount77UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert77UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo77ViewModel @Inject constructor(
    private val insert77UseCase: Insert77UseCase,
    private val delete77UseCase: Delete77UseCase,
    private val getAll77UseCase: GetAll77UseCase,
    private val deleteAll77UseCase: DeleteAll77UseCase,
    private val getRowCount77UseCase: GetRowCount77UseCase
) : ViewModel() {


    private val _photos77 = MutableStateFlow<List<Photo77>>(emptyList())
    val photos77: StateFlow<List<Photo77>> = _photos77

    init {
        viewModelScope.launch {
            getAll77UseCase.photoExecute().collect { photoList ->
                _photos77.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo77: Photo77) {
        viewModelScope.launch(Dispatchers.IO) {
            insert77UseCase.photoExecute(photo77)
        }
    }
    fun deleteNewPhoto(photo77 : Photo77, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete77UseCase.photoExecute(photo77)
                _photos77.value = photos77.value.filterNot { it == photo77 }
                val uri = Uri.parse(photo77.image)
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
    fun deleteAll77Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll77UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll77UseCase.photoExecute()
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
        return getRowCount77UseCase.photoExecute() == 0
    }
}