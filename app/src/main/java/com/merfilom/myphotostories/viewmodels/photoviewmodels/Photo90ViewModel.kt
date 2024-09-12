package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo90
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete90UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll90UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll90UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount90UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert90UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo90ViewModel @Inject constructor(
    private val insert90UseCase: Insert90UseCase,
    private val delete90UseCase: Delete90UseCase,
    private val getAll90UseCase: GetAll90UseCase,
    private val deleteAll90UseCase: DeleteAll90UseCase,
    private val getRowCount90UseCase: GetRowCount90UseCase
) : ViewModel() {


    private val _photos90 = MutableStateFlow<List<Photo90>>(emptyList())
    val photos90: StateFlow<List<Photo90>> = _photos90

    init {
        viewModelScope.launch {
            getAll90UseCase.photoExecute().collect { photoList ->
                _photos90.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo90: Photo90) {
        viewModelScope.launch(Dispatchers.IO) {
            insert90UseCase.photoExecute(photo90)
        }
    }
    fun deleteNewPhoto(photo90 : Photo90, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete90UseCase.photoExecute(photo90)
                _photos90.value = photos90.value.filterNot { it == photo90 }
                val uri = Uri.parse(photo90.image)
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
    fun deleteAll90Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll90UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll90UseCase.photoExecute()
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
        return getRowCount90UseCase.photoExecute() == 0
    }
}