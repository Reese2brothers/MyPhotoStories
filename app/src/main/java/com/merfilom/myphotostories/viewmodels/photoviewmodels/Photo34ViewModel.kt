package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo34
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete34UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll34UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll34UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount34UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert34UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo34ViewModel @Inject constructor(
    private val insert34UseCase: Insert34UseCase,
    private val delete34UseCase: Delete34UseCase,
    private val getAll34UseCase: GetAll34UseCase,
    private val deleteAll34UseCase: DeleteAll34UseCase,
    private val getRowCount34UseCase: GetRowCount34UseCase
) : ViewModel() {


    private val _photos34 = MutableStateFlow<List<Photo34>>(emptyList())
    val photos34: StateFlow<List<Photo34>> = _photos34

    init {
        viewModelScope.launch {
            getAll34UseCase.photoExecute().collect { photoList ->
                _photos34.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo34: Photo34) {
        viewModelScope.launch(Dispatchers.IO) {
            insert34UseCase.photoExecute(photo34)
        }
    }
    fun deleteNewPhoto(photo34 : Photo34, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete34UseCase.photoExecute(photo34)
                _photos34.value = photos34.value.filterNot { it == photo34 }
                val uri = Uri.parse(photo34.image)
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

    fun deleteAll34Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll34UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll34UseCase.photoExecute()
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
        return getRowCount34UseCase.photoExecute() == 0
    }
}