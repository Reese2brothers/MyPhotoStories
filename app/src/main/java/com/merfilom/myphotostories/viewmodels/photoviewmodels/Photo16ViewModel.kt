package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo16
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete16UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll16UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll16UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount16UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert16UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo16ViewModel @Inject constructor(
    private val insert16UseCase: Insert16UseCase,
    private val delete16UseCase: Delete16UseCase,
    private val getAll16UseCase: GetAll16UseCase,
    private val deleteAll16UseCase: DeleteAll16UseCase,
    private val getRowCount16UseCase: GetRowCount16UseCase
) : ViewModel() {


    private val _photos16 = MutableStateFlow<List<Photo16>>(emptyList())
    val photos16: StateFlow<List<Photo16>> = _photos16

    init {
        viewModelScope.launch {
            getAll16UseCase.photoExecute().collect { photoList ->
                _photos16.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo16: Photo16) {
        viewModelScope.launch(Dispatchers.IO) {
            insert16UseCase.photoExecute(photo16)
        }
    }
    fun deleteNewPhoto(photo16 : Photo16, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete16UseCase.photoExecute(photo16)
                _photos16.value = photos16.value.filterNot { it == photo16 }
                val uri = Uri.parse(photo16.image)
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
    fun deleteAll16Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll16UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll16UseCase.photoExecute()
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
        return getRowCount16UseCase.photoExecute() == 0
    }
}