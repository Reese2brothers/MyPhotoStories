package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo60
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete60UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll60UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll60UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount60UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert60UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo60ViewModel @Inject constructor(
    private val insert60UseCase: Insert60UseCase,
    private val delete60UseCase: Delete60UseCase,
    private val getAll60UseCase: GetAll60UseCase,
    private val deleteAll60UseCase: DeleteAll60UseCase,
    private val getRowCount60UseCase: GetRowCount60UseCase
) : ViewModel() {


    private val _photos60 = MutableStateFlow<List<Photo60>>(emptyList())
    val photos60: StateFlow<List<Photo60>> = _photos60

    init {
        viewModelScope.launch {
            getAll60UseCase.photoExecute().collect { photoList ->
                _photos60.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo60: Photo60) {
        viewModelScope.launch(Dispatchers.IO) {
            insert60UseCase.photoExecute(photo60)
        }
    }
    fun deleteNewPhoto(photo60 : Photo60, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete60UseCase.photoExecute(photo60)
                _photos60.value = photos60.value.filterNot { it == photo60 }
                val uri = Uri.parse(photo60.image)
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
    fun deleteAll60Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll60UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll60UseCase.photoExecute()
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
        return getRowCount60UseCase.photoExecute() == 0
    }
}