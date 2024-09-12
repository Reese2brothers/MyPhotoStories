package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo84
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete84UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll84UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll84UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount84UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert84UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo84ViewModel @Inject constructor(
    private val insert84UseCase: Insert84UseCase,
    private val delete84UseCase: Delete84UseCase,
    private val getAll84UseCase: GetAll84UseCase,
    private val deleteAll84UseCase: DeleteAll84UseCase,
    private val getRowCount84UseCase: GetRowCount84UseCase
) : ViewModel() {


    private val _photos84 = MutableStateFlow<List<Photo84>>(emptyList())
    val photos84: StateFlow<List<Photo84>> = _photos84

    init {
        viewModelScope.launch {
            getAll84UseCase.photoExecute().collect { photoList ->
                _photos84.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo84: Photo84) {
        viewModelScope.launch(Dispatchers.IO) {
            insert84UseCase.photoExecute(photo84)
        }
    }
    fun deleteNewPhoto(photo84 : Photo84, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete84UseCase.photoExecute(photo84)
                _photos84.value = photos84.value.filterNot { it == photo84 }
                val uri = Uri.parse(photo84.image)
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
    fun deleteAll84Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll84UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll84UseCase.photoExecute()
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
        return getRowCount84UseCase.photoExecute() == 0
    }
}