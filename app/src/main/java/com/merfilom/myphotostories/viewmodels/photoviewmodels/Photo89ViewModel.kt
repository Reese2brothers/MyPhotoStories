package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo89
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete89UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll89UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll89UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount89UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert89UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo89ViewModel @Inject constructor(
    private val insert89UseCase: Insert89UseCase,
    private val delete89UseCase: Delete89UseCase,
    private val getAll89UseCase: GetAll89UseCase,
    private val deleteAll89UseCase: DeleteAll89UseCase,
    private val getRowCount89UseCase: GetRowCount89UseCase
) : ViewModel() {


    private val _photos89 = MutableStateFlow<List<Photo89>>(emptyList())
    val photos89: StateFlow<List<Photo89>> = _photos89

    init {
        viewModelScope.launch {
            getAll89UseCase.photoExecute().collect { photoList ->
                _photos89.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo89: Photo89) {
        viewModelScope.launch(Dispatchers.IO) {
            insert89UseCase.photoExecute(photo89)
        }
    }
    fun deleteNewPhoto(photo89 : Photo89, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete89UseCase.photoExecute(photo89)
                _photos89.value = photos89.value.filterNot { it == photo89 }
                val uri = Uri.parse(photo89.image)
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
    fun deleteAll89Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll89UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll89UseCase.photoExecute()
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
        return getRowCount89UseCase.photoExecute() == 0
    }
}