package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo71
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete71UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll71UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll71UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount71UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert71UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo71ViewModel @Inject constructor(
    private val insert71UseCase: Insert71UseCase,
    private val delete71UseCase: Delete71UseCase,
    private val getAll71UseCase: GetAll71UseCase,
    private val deleteAll71UseCase: DeleteAll71UseCase,
    private val getRowCount71UseCase: GetRowCount71UseCase
) : ViewModel() {


    private val _photos71 = MutableStateFlow<List<Photo71>>(emptyList())
    val photos71: StateFlow<List<Photo71>> = _photos71

    init {
        viewModelScope.launch {
            getAll71UseCase.photoExecute().collect { photoList ->
                _photos71.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo71: Photo71) {
        viewModelScope.launch(Dispatchers.IO) {
            insert71UseCase.photoExecute(photo71)
        }
    }
    fun deleteNewPhoto(photo71 : Photo71, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete71UseCase.photoExecute(photo71)
                _photos71.value = photos71.value.filterNot { it == photo71 }
                val uri = Uri.parse(photo71.image)
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
    fun deleteAll71Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll71UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll71UseCase.photoExecute()
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
        return getRowCount71UseCase.photoExecute() == 0
    }
}