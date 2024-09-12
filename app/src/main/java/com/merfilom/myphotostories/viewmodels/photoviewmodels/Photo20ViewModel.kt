package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo20
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete20UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll20UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll20UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount20UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert20UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo20ViewModel @Inject constructor(
    private val insert20UseCase: Insert20UseCase,
    private val delete20UseCase: Delete20UseCase,
    private val getAll20UseCase: GetAll20UseCase,
    private val deleteAll20UseCase: DeleteAll20UseCase,
    private val getRowCount20UseCase: GetRowCount20UseCase
) : ViewModel() {


    private val _photos20 = MutableStateFlow<List<Photo20>>(emptyList())
    val photos20: StateFlow<List<Photo20>> = _photos20

    init {
        viewModelScope.launch {
            getAll20UseCase.photoExecute().collect { photoList ->
                _photos20.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo20: Photo20) {
        viewModelScope.launch(Dispatchers.IO) {
            insert20UseCase.photoExecute(photo20)
        }
    }
    fun deleteNewPhoto(photo20 : Photo20, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete20UseCase.photoExecute(photo20)
                _photos20.value = photos20.value.filterNot { it == photo20 }
                val uri = Uri.parse(photo20.image)
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

    fun deleteAll20Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll20UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll20UseCase.photoExecute()
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
        return getRowCount20UseCase.photoExecute() == 0
    }
}