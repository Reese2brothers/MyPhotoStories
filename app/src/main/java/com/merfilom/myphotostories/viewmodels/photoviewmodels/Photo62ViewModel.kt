package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo62
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete62UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll62UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll62UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount62UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert62UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo62ViewModel @Inject constructor(
    private val insert62UseCase: Insert62UseCase,
    private val delete62UseCase: Delete62UseCase,
    private val getAll62UseCase: GetAll62UseCase,
    private val deleteAll62UseCase: DeleteAll62UseCase,
    private val getRowCount62UseCase: GetRowCount62UseCase
) : ViewModel() {


    private val _photos62 = MutableStateFlow<List<Photo62>>(emptyList())
    val photos62: StateFlow<List<Photo62>> = _photos62

    init {
        viewModelScope.launch {
            getAll62UseCase.photoExecute().collect { photoList ->
                _photos62.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo62: Photo62) {
        viewModelScope.launch(Dispatchers.IO) {
            insert62UseCase.photoExecute(photo62)
        }
    }
    fun deleteNewPhoto(photo62 : Photo62, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete62UseCase.photoExecute(photo62)
                _photos62.value = photos62.value.filterNot { it == photo62 }
                val uri = Uri.parse(photo62.image)
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
    fun deleteAll62Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll62UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll62UseCase.photoExecute()
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
        return getRowCount62UseCase.photoExecute() == 0
    }
}