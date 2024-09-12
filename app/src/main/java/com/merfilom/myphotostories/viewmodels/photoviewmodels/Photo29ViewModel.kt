package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo29
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete29UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll29UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll29UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount29UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert29UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo29ViewModel @Inject constructor(
    private val insert29UseCase: Insert29UseCase,
    private val delete29UseCase: Delete29UseCase,
    private val getAll29UseCase: GetAll29UseCase,
    private val deleteAll29UseCase: DeleteAll29UseCase,
    private val getRowCount29UseCase: GetRowCount29UseCase
) : ViewModel() {


    private val _photos29 = MutableStateFlow<List<Photo29>>(emptyList())
    val photos29: StateFlow<List<Photo29>> = _photos29

    init {
        viewModelScope.launch {
            getAll29UseCase.photoExecute().collect { photoList ->
                _photos29.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo29: Photo29) {
        viewModelScope.launch(Dispatchers.IO) {
            insert29UseCase.photoExecute(photo29)
        }
    }
    fun deleteNewPhoto(photo29 : Photo29, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete29UseCase.photoExecute(photo29)
                _photos29.value = photos29.value.filterNot { it == photo29 }
                val uri = Uri.parse(photo29.image)
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

    fun deleteAll29Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll29UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll29UseCase.photoExecute()
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
        return getRowCount29UseCase.photoExecute() == 0
    }
}