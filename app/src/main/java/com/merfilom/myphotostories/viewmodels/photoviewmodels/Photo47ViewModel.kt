package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo47
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete47UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll47UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll47UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount47UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert47UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo47ViewModel @Inject constructor(
    private val insert47UseCase: Insert47UseCase,
    private val delete47UseCase: Delete47UseCase,
    private val getAll47UseCase: GetAll47UseCase,
    private val deleteAll47UseCase: DeleteAll47UseCase,
    private val getRowCount47UseCase: GetRowCount47UseCase
) : ViewModel() {


    private val _photos47 = MutableStateFlow<List<Photo47>>(emptyList())
    val photos47: StateFlow<List<Photo47>> = _photos47

    init {
        viewModelScope.launch {
            getAll47UseCase.photoExecute().collect { photoList ->
                _photos47.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo47: Photo47) {
        viewModelScope.launch(Dispatchers.IO) {
            insert47UseCase.photoExecute(photo47)
        }
    }
    fun deleteNewPhoto(photo47 : Photo47, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete47UseCase.photoExecute(photo47)
                _photos47.value = photos47.value.filterNot { it == photo47 }
                val uri = Uri.parse(photo47.image)
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

    fun deleteAll47Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll47UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll47UseCase.photoExecute()
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
        return getRowCount47UseCase.photoExecute() == 0
    }
}