package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo27
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete27UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll27UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll27UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount27UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert27UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo27ViewModel @Inject constructor(
    private val insert27UseCase: Insert27UseCase,
    private val delete27UseCase: Delete27UseCase,
    private val getAll27UseCase: GetAll27UseCase,
    private val deleteAll27UseCase: DeleteAll27UseCase,
    private val getRowCount27UseCase: GetRowCount27UseCase
) : ViewModel() {


    private val _photos27 = MutableStateFlow<List<Photo27>>(emptyList())
    val photos27: StateFlow<List<Photo27>> = _photos27

    init {
        viewModelScope.launch {
            getAll27UseCase.photoExecute().collect { photoList ->
                _photos27.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo27: Photo27) {
        viewModelScope.launch(Dispatchers.IO) {
            insert27UseCase.photoExecute(photo27)
        }
    }
    fun deleteNewPhoto(photo27 : Photo27, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete27UseCase.photoExecute(photo27)
                _photos27.value = photos27.value.filterNot { it == photo27 }
                val uri = Uri.parse(photo27.image)
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

    fun deleteAll27Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll27UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll27UseCase.photoExecute()
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
        return getRowCount27UseCase.photoExecute() == 0
    }
}