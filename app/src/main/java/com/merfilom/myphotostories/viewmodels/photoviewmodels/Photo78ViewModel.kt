package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo78
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete78UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll78UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll78UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount78UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert78UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo78ViewModel @Inject constructor(
    private val insert78UseCase: Insert78UseCase,
    private val delete78UseCase: Delete78UseCase,
    private val getAll78UseCase: GetAll78UseCase,
    private val deleteAll78UseCase: DeleteAll78UseCase,
    private val getRowCount78UseCase: GetRowCount78UseCase
) : ViewModel() {


    private val _photos78 = MutableStateFlow<List<Photo78>>(emptyList())
    val photos78: StateFlow<List<Photo78>> = _photos78

    init {
        viewModelScope.launch {
            getAll78UseCase.photoExecute().collect { photoList ->
                _photos78.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo78: Photo78) {
        viewModelScope.launch(Dispatchers.IO) {
            insert78UseCase.photoExecute(photo78)
        }
    }
    fun deleteNewPhoto(photo78 : Photo78, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete78UseCase.photoExecute(photo78)
                _photos78.value = photos78.value.filterNot { it == photo78 }
                val uri = Uri.parse(photo78.image)
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
    fun deleteAll78Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll78UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll78UseCase.photoExecute()
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
        return getRowCount78UseCase.photoExecute() == 0
    }
}