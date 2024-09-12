package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo8
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete8UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll8UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll8UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount8UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert8UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo8ViewModel @Inject constructor(
    private val insert8UseCase: Insert8UseCase,
    private val delete8UseCase: Delete8UseCase,
    private val getAll8UseCase: GetAll8UseCase,
    private val deleteAll8UseCase: DeleteAll8UseCase,
    private val getRowCount8UseCase: GetRowCount8UseCase
) : ViewModel() {


    private val _photos8 = MutableStateFlow<List<Photo8>>(emptyList())
    val photos8: StateFlow<List<Photo8>> = _photos8

    init {
        viewModelScope.launch {
            getAll8UseCase.photoExecute().collect { photoList ->
                _photos8.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo8: Photo8) {
        viewModelScope.launch(Dispatchers.IO) {
            insert8UseCase.photoExecute(photo8)
        }
    }
    fun deleteNewPhoto(photo8 : Photo8, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete8UseCase.photoExecute(photo8)
                _photos8.value = photos8.value.filterNot { it == photo8 }
                val uri = Uri.parse(photo8.image)
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
    fun deleteAll8Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll8UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll8UseCase.photoExecute()
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
        return getRowCount8UseCase.photoExecute() == 0
    }
}