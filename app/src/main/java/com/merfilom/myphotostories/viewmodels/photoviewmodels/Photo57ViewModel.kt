package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo57
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete57UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll57UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll57UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount57UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert57UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo57ViewModel @Inject constructor(
    private val insert57UseCase: Insert57UseCase,
    private val delete57UseCase: Delete57UseCase,
    private val getAll57UseCase: GetAll57UseCase,
    private val deleteAll57UseCase: DeleteAll57UseCase,
    private val getRowCount57UseCase: GetRowCount57UseCase
) : ViewModel() {


    private val _photos57 = MutableStateFlow<List<Photo57>>(emptyList())
    val photos57: StateFlow<List<Photo57>> = _photos57

    init {
        viewModelScope.launch {
            getAll57UseCase.photoExecute().collect { photoList ->
                _photos57.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo57: Photo57) {
        viewModelScope.launch(Dispatchers.IO) {
            insert57UseCase.photoExecute(photo57)
        }
    }
    fun deleteNewPhoto(photo57 : Photo57, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete57UseCase.photoExecute(photo57)
                _photos57.value = photos57.value.filterNot { it == photo57 }
                val uri = Uri.parse(photo57.image)
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
    fun deleteAll57Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll57UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll57UseCase.photoExecute()
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
        return getRowCount57UseCase.photoExecute() == 0
    }
}