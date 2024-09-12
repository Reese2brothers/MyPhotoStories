package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo95
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete95UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll95UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll95UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount95UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert95UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo95ViewModel @Inject constructor(
    private val insert95UseCase: Insert95UseCase,
    private val delete95UseCase: Delete95UseCase,
    private val getAll95UseCase: GetAll95UseCase,
    private val deleteAll95UseCase: DeleteAll95UseCase,
    private val getRowCount95UseCase: GetRowCount95UseCase
) : ViewModel() {


    private val _photos95 = MutableStateFlow<List<Photo95>>(emptyList())
    val photos95: StateFlow<List<Photo95>> = _photos95

    init {
        viewModelScope.launch {
            getAll95UseCase.photoExecute().collect { photoList ->
                _photos95.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo95: Photo95) {
        viewModelScope.launch(Dispatchers.IO) {
            insert95UseCase.photoExecute(photo95)
        }
    }
    fun deleteNewPhoto(photo95 : Photo95, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete95UseCase.photoExecute(photo95)
                _photos95.value = photos95.value.filterNot { it == photo95 }
                val uri = Uri.parse(photo95.image)
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
    fun deleteAll95Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll95UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll95UseCase.photoExecute()
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
        return getRowCount95UseCase.photoExecute() == 0
    }
}