package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo73
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete73UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll73UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll73UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount73UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert73UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo73ViewModel @Inject constructor(
    private val insert73UseCase: Insert73UseCase,
    private val delete73UseCase: Delete73UseCase,
    private val getAll73UseCase: GetAll73UseCase,
    private val deleteAll73UseCase: DeleteAll73UseCase,
    private val getRowCount73UseCase: GetRowCount73UseCase
) : ViewModel() {


    private val _photos73 = MutableStateFlow<List<Photo73>>(emptyList())
    val photos73: StateFlow<List<Photo73>> = _photos73

    init {
        viewModelScope.launch {
            getAll73UseCase.photoExecute().collect { photoList ->
                _photos73.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo73: Photo73) {
        viewModelScope.launch(Dispatchers.IO) {
            insert73UseCase.photoExecute(photo73)
        }
    }
    fun deleteNewPhoto(photo73 : Photo73, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete73UseCase.photoExecute(photo73)
                _photos73.value = photos73.value.filterNot { it == photo73 }
                val uri = Uri.parse(photo73.image)
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
    fun deleteAll73Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll73UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll73UseCase.photoExecute()
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
        return getRowCount73UseCase.photoExecute() == 0
    }
}