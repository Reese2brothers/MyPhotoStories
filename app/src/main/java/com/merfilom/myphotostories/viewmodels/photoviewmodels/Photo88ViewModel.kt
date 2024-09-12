package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo88
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete88UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll88UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll88UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount88UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert88UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo88ViewModel @Inject constructor(
    private val insert88UseCase: Insert88UseCase,
    private val delete88UseCase: Delete88UseCase,
    private val getAll88UseCase: GetAll88UseCase,
    private val deleteAll88UseCase: DeleteAll88UseCase,
    private val getRowCount88UseCase: GetRowCount88UseCase
) : ViewModel() {


    private val _photos88 = MutableStateFlow<List<Photo88>>(emptyList())
    val photos88: StateFlow<List<Photo88>> = _photos88

    init {
        viewModelScope.launch {
            getAll88UseCase.photoExecute().collect { photoList ->
                _photos88.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo88: Photo88) {
        viewModelScope.launch(Dispatchers.IO) {
            insert88UseCase.photoExecute(photo88)
        }
    }
    fun deleteNewPhoto(photo88 : Photo88, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete88UseCase.photoExecute(photo88)
                _photos88.value = photos88.value.filterNot { it == photo88 }
                val uri = Uri.parse(photo88.image)
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
    fun deleteAll88Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll88UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll88UseCase.photoExecute()
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
        return getRowCount88UseCase.photoExecute() == 0
    }
}