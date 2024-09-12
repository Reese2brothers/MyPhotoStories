package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo74
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete74UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll74UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll74UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount74UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert74UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo74ViewModel @Inject constructor(
    private val insert74UseCase: Insert74UseCase,
    private val delete74UseCase: Delete74UseCase,
    private val getAll74UseCase: GetAll74UseCase,
    private val deleteAll74UseCase: DeleteAll74UseCase,
    private val getRowCount74UseCase: GetRowCount74UseCase
) : ViewModel() {


    private val _photos74 = MutableStateFlow<List<Photo74>>(emptyList())
    val photos74: StateFlow<List<Photo74>> = _photos74

    init {
        viewModelScope.launch {
            getAll74UseCase.photoExecute().collect { photoList ->
                _photos74.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo74: Photo74) {
        viewModelScope.launch(Dispatchers.IO) {
            insert74UseCase.photoExecute(photo74)
        }
    }
    fun deleteNewPhoto(photo74 : Photo74, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete74UseCase.photoExecute(photo74)
                _photos74.value = photos74.value.filterNot { it == photo74 }
                val uri = Uri.parse(photo74.image)
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
    fun deleteAll74Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll74UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll74UseCase.photoExecute()
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
        return getRowCount74UseCase.photoExecute() == 0
    }
}