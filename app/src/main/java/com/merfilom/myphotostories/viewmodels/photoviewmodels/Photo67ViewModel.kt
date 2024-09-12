package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo67
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete67UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll67UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll67UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount67UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert67UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo67ViewModel @Inject constructor(
    private val insert67UseCase: Insert67UseCase,
    private val delete67UseCase: Delete67UseCase,
    private val getAll67UseCase: GetAll67UseCase,
    private val deleteAll67UseCase: DeleteAll67UseCase,
    private val getRowCount67UseCase: GetRowCount67UseCase
) : ViewModel() {


    private val _photos67 = MutableStateFlow<List<Photo67>>(emptyList())
    val photos67: StateFlow<List<Photo67>> = _photos67

    init {
        viewModelScope.launch {
            getAll67UseCase.photoExecute().collect { photoList ->
                _photos67.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo67: Photo67) {
        viewModelScope.launch(Dispatchers.IO) {
            insert67UseCase.photoExecute(photo67)
        }
    }
    fun deleteNewPhoto(photo67 : Photo67, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete67UseCase.photoExecute(photo67)
                _photos67.value = photos67.value.filterNot { it == photo67 }
                val uri = Uri.parse(photo67.image)
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
    fun deleteAll67Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll67UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll67UseCase.photoExecute()
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
        return getRowCount67UseCase.photoExecute() == 0
    }
}