package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo82
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete82UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll82UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll82UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount82UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert82UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo82ViewModel @Inject constructor(
    private val insert82UseCase: Insert82UseCase,
    private val delete82UseCase: Delete82UseCase,
    private val getAll82UseCase: GetAll82UseCase,
    private val deleteAll82UseCase: DeleteAll82UseCase,
    private val getRowCount82UseCase: GetRowCount82UseCase
) : ViewModel() {


    private val _photos82 = MutableStateFlow<List<Photo82>>(emptyList())
    val photos82: StateFlow<List<Photo82>> = _photos82

    init {
        viewModelScope.launch {
            getAll82UseCase.photoExecute().collect { photoList ->
                _photos82.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo82: Photo82) {
        viewModelScope.launch(Dispatchers.IO) {
            insert82UseCase.photoExecute(photo82)
        }
    }
    fun deleteNewPhoto(photo82 : Photo82, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete82UseCase.photoExecute(photo82)
                _photos82.value = photos82.value.filterNot { it == photo82 }
                val uri = Uri.parse(photo82.image)
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
    fun deleteAll82Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll82UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll82UseCase.photoExecute()
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
        return getRowCount82UseCase.photoExecute() == 0
    }
}