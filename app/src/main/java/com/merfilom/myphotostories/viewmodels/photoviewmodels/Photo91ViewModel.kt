package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo91
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete91UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll91UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll91UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount91UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert91UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo91ViewModel @Inject constructor(
    private val insert91UseCase: Insert91UseCase,
    private val delete91UseCase: Delete91UseCase,
    private val getAll91UseCase: GetAll91UseCase,
    private val deleteAll91UseCase: DeleteAll91UseCase,
    private val getRowCount91UseCase: GetRowCount91UseCase
) : ViewModel() {


    private val _photos91 = MutableStateFlow<List<Photo91>>(emptyList())
    val photos91: StateFlow<List<Photo91>> = _photos91

    init {
        viewModelScope.launch {
            getAll91UseCase.photoExecute().collect { photoList ->
                _photos91.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo91: Photo91) {
        viewModelScope.launch(Dispatchers.IO) {
            insert91UseCase.photoExecute(photo91)
        }
    }
    fun deleteNewPhoto(photo91 : Photo91, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete91UseCase.photoExecute(photo91)
                _photos91.value = photos91.value.filterNot { it == photo91 }
                val uri = Uri.parse(photo91.image)
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
    fun deleteAll91Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll91UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll91UseCase.photoExecute()
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
        return getRowCount91UseCase.photoExecute() == 0
    }
}