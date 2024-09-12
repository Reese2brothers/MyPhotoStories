package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo83
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete83UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll83UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll83UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount83UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert83UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo83ViewModel @Inject constructor(
    private val insert83UseCase: Insert83UseCase,
    private val delete83UseCase: Delete83UseCase,
    private val getAll83UseCase: GetAll83UseCase,
    private val deleteAll83UseCase: DeleteAll83UseCase,
    private val getRowCount83UseCase: GetRowCount83UseCase
) : ViewModel() {


    private val _photos83 = MutableStateFlow<List<Photo83>>(emptyList())
    val photos83: StateFlow<List<Photo83>> = _photos83

    init {
        viewModelScope.launch {
            getAll83UseCase.photoExecute().collect { photoList ->
                _photos83.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo83: Photo83) {
        viewModelScope.launch(Dispatchers.IO) {
            insert83UseCase.photoExecute(photo83)
        }
    }
    fun deleteNewPhoto(photo83 : Photo83, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete83UseCase.photoExecute(photo83)
                _photos83.value = photos83.value.filterNot { it == photo83 }
                val uri = Uri.parse(photo83.image)
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
    fun deleteAll83Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll83UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll83UseCase.photoExecute()
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
        return getRowCount83UseCase.photoExecute() == 0
    }
}