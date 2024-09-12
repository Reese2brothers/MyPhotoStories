package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo10
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete10UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll10UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll10UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount10UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert10UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo10ViewModel @Inject constructor(
    private val insert10UseCase: Insert10UseCase,
    private val delete10UseCase: Delete10UseCase,
    private val getAll10UseCase: GetAll10UseCase,
    private val deleteAll10UseCase: DeleteAll10UseCase,
    private val getRowCount10UseCase: GetRowCount10UseCase
) : ViewModel() {


    private val _photos10 = MutableStateFlow<List<Photo10>>(emptyList())
    val photos10: StateFlow<List<Photo10>> = _photos10

    init {
        viewModelScope.launch {
            getAll10UseCase.photoExecute().collect { photoList ->
                _photos10.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo10: Photo10) {
        viewModelScope.launch(Dispatchers.IO) {
            insert10UseCase.photoExecute(photo10)
        }
    }
    fun deleteNewPhoto(photo10 : Photo10, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete10UseCase.photoExecute(photo10)
                _photos10.value = photos10.value.filterNot { it == photo10 }
                val uri = Uri.parse(photo10.image)
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
    fun deleteAll10Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll10UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll10UseCase.photoExecute()
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
        return getRowCount10UseCase.photoExecute() == 0
    }
}