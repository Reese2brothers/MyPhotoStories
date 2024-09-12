package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo45
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete45UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll45UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll45UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount45UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert45UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo45ViewModel @Inject constructor(
    private val insert45UseCase: Insert45UseCase,
    private val delete45UseCase: Delete45UseCase,
    private val getAll45UseCase: GetAll45UseCase,
    private val deleteAll45UseCase: DeleteAll45UseCase,
    private val getRowCount45UseCase: GetRowCount45UseCase
) : ViewModel() {


    private val _photos45 = MutableStateFlow<List<Photo45>>(emptyList())
    val photos45: StateFlow<List<Photo45>> = _photos45

    init {
        viewModelScope.launch {
            getAll45UseCase.photoExecute().collect { photoList ->
                _photos45.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo45: Photo45) {
        viewModelScope.launch(Dispatchers.IO) {
            insert45UseCase.photoExecute(photo45)
        }
    }
    fun deleteNewPhoto(photo45 : Photo45, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete45UseCase.photoExecute(photo45)
                _photos45.value = photos45.value.filterNot { it == photo45 }
                val uri = Uri.parse(photo45.image)
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

    fun deleteAll45Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll45UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll45UseCase.photoExecute()
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
        return getRowCount45UseCase.photoExecute() == 0
    }
}