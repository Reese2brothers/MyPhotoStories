package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo25
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete25UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll25UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll25UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount25UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert25UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo25ViewModel @Inject constructor(
    private val insert25UseCase: Insert25UseCase,
    private val delete25UseCase: Delete25UseCase,
    private val getAll25UseCase: GetAll25UseCase,
    private val deleteAll25UseCase: DeleteAll25UseCase,
    private val getRowCount25UseCase: GetRowCount25UseCase
) : ViewModel() {


    private val _photos25 = MutableStateFlow<List<Photo25>>(emptyList())
    val photos25: StateFlow<List<Photo25>> = _photos25

    init {
        viewModelScope.launch {
            getAll25UseCase.photoExecute().collect { photoList ->
                _photos25.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo25: Photo25) {
        viewModelScope.launch(Dispatchers.IO) {
            insert25UseCase.photoExecute(photo25)
        }
    }
    fun deleteNewPhoto(photo25 : Photo25, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete25UseCase.photoExecute(photo25)
                _photos25.value = photos25.value.filterNot { it == photo25 }
                val uri = Uri.parse(photo25.image)
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

    fun deleteAll25Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll25UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll25UseCase.photoExecute()
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
        return getRowCount25UseCase.photoExecute() == 0
    }
}