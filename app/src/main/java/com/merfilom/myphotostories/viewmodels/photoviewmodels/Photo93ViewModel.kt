package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo93
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete93UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll93UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll93UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount93UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert93UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo93ViewModel @Inject constructor(
    private val insert93UseCase: Insert93UseCase,
    private val delete93UseCase: Delete93UseCase,
    private val getAll93UseCase: GetAll93UseCase,
    private val deleteAll93UseCase: DeleteAll93UseCase,
    private val getRowCount93UseCase: GetRowCount93UseCase
) : ViewModel() {


    private val _photos93 = MutableStateFlow<List<Photo93>>(emptyList())
    val photos93: StateFlow<List<Photo93>> = _photos93

    init {
        viewModelScope.launch {
            getAll93UseCase.photoExecute().collect { photoList ->
                _photos93.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo93: Photo93) {
        viewModelScope.launch(Dispatchers.IO) {
            insert93UseCase.photoExecute(photo93)
        }
    }
    fun deleteNewPhoto(photo93 : Photo93, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete93UseCase.photoExecute(photo93)
                _photos93.value = photos93.value.filterNot { it == photo93 }
                val uri = Uri.parse(photo93.image)
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
    fun deleteAll93Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll93UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll93UseCase.photoExecute()
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
        return getRowCount93UseCase.photoExecute() == 0
    }
}