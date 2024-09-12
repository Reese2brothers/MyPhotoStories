package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo65
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete65UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll65UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll65UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount65UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert65UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo65ViewModel @Inject constructor(
    private val insert65UseCase: Insert65UseCase,
    private val delete65UseCase: Delete65UseCase,
    private val getAll65UseCase: GetAll65UseCase,
    private val deleteAll65UseCase: DeleteAll65UseCase,
    private val getRowCount65UseCase: GetRowCount65UseCase
) : ViewModel() {


    private val _photos65 = MutableStateFlow<List<Photo65>>(emptyList())
    val photos65: StateFlow<List<Photo65>> = _photos65

    init {
        viewModelScope.launch {
            getAll65UseCase.photoExecute().collect { photoList ->
                _photos65.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo65: Photo65) {
        viewModelScope.launch(Dispatchers.IO) {
            insert65UseCase.photoExecute(photo65)
        }
    }
    fun deleteNewPhoto(photo65 : Photo65, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete65UseCase.photoExecute(photo65)
                _photos65.value = photos65.value.filterNot { it == photo65 }
                val uri = Uri.parse(photo65.image)
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
    fun deleteAll65Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll65UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll65UseCase.photoExecute()
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
        return getRowCount65UseCase.photoExecute() == 0
    }
}