package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo54
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete54UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll54UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll54UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount54UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert54UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo54ViewModel @Inject constructor(
    private val insert54UseCase: Insert54UseCase,
    private val delete54UseCase: Delete54UseCase,
    private val getAll54UseCase: GetAll54UseCase,
    private val deleteAll54UseCase: DeleteAll54UseCase,
    private val getRowCount54UseCase: GetRowCount54UseCase
) : ViewModel() {


    private val _photos54 = MutableStateFlow<List<Photo54>>(emptyList())
    val photos54: StateFlow<List<Photo54>> = _photos54

    init {
        viewModelScope.launch {
            getAll54UseCase.photoExecute().collect { photoList ->
                _photos54.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo54: Photo54) {
        viewModelScope.launch(Dispatchers.IO) {
            insert54UseCase.photoExecute(photo54)
        }
    }
    fun deleteNewPhoto(photo54 : Photo54, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete54UseCase.photoExecute(photo54)
                _photos54.value = photos54.value.filterNot { it == photo54 }
                val uri = Uri.parse(photo54.image)
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
    fun deleteAll54Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll54UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll54UseCase.photoExecute()
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
        return getRowCount54UseCase.photoExecute() == 0
    }
}