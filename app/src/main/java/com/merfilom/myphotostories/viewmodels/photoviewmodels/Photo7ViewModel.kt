package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo7
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete7UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll7UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll7UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount7UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert7UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo7ViewModel @Inject constructor(
    private val insert7UseCase: Insert7UseCase,
    private val delete7UseCase: Delete7UseCase,
    private val getAll7UseCase: GetAll7UseCase,
    private val deleteAll7UseCase: DeleteAll7UseCase,
    private val getRowCount7UseCase: GetRowCount7UseCase
) : ViewModel() {


    private val _photos7 = MutableStateFlow<List<Photo7>>(emptyList())
    val photos7: StateFlow<List<Photo7>> = _photos7

    init {
        viewModelScope.launch {
            getAll7UseCase.photoExecute().collect { photoList ->
                _photos7.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo7: Photo7) {
        viewModelScope.launch(Dispatchers.IO) {
            insert7UseCase.photoExecute(photo7)
        }
    }
    fun deleteNewPhoto(photo7 : Photo7, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete7UseCase.photoExecute(photo7)
                _photos7.value = photos7.value.filterNot { it == photo7 }
                val uri = Uri.parse(photo7.image)
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
    fun deleteAll7Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll7UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll7UseCase.photoExecute()
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
        return getRowCount7UseCase.photoExecute() == 0
    }
}