package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo36
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete36UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll36UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll36UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount36UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert36UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo36ViewModel @Inject constructor(
    private val insert36UseCase: Insert36UseCase,
    private val delete36UseCase: Delete36UseCase,
    private val getAll36UseCase: GetAll36UseCase,
    private val deleteAll36UseCase: DeleteAll36UseCase,
    private val getRowCount36UseCase: GetRowCount36UseCase
) : ViewModel() {


    private val _photos36 = MutableStateFlow<List<Photo36>>(emptyList())
    val photos36: StateFlow<List<Photo36>> = _photos36

    init {
        viewModelScope.launch {
            getAll36UseCase.photoExecute().collect { photoList ->
                _photos36.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo36: Photo36) {
        viewModelScope.launch(Dispatchers.IO) {
            insert36UseCase.photoExecute(photo36)
        }
    }
    fun deleteNewPhoto(photo36 : Photo36, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete36UseCase.photoExecute(photo36)
                _photos36.value = photos36.value.filterNot { it == photo36 }
                val uri = Uri.parse(photo36.image)
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

    fun deleteAll36Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll36UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll36UseCase.photoExecute()
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
        return getRowCount36UseCase.photoExecute() == 0
    }
}