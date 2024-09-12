package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo61
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete61UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll61UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll61UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount61UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert61UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo61ViewModel @Inject constructor(
    private val insert61UseCase: Insert61UseCase,
    private val delete61UseCase: Delete61UseCase,
    private val getAll61UseCase: GetAll61UseCase,
    private val deleteAll61UseCase: DeleteAll61UseCase,
    private val getRowCount61UseCase: GetRowCount61UseCase
) : ViewModel() {


    private val _photos61 = MutableStateFlow<List<Photo61>>(emptyList())
    val photos61: StateFlow<List<Photo61>> = _photos61

    init {
        viewModelScope.launch {
            getAll61UseCase.photoExecute().collect { photoList ->
                _photos61.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo61: Photo61) {
        viewModelScope.launch(Dispatchers.IO) {
            insert61UseCase.photoExecute(photo61)
        }
    }
    fun deleteNewPhoto(photo61 : Photo61, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete61UseCase.photoExecute(photo61)
                _photos61.value = photos61.value.filterNot { it == photo61 }
                val uri = Uri.parse(photo61.image)
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
    fun deleteAll61Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll61UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll61UseCase.photoExecute()
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
        return getRowCount61UseCase.photoExecute() == 0
    }
}