package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo38
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete38UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll38UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll38UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount38UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert38UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo38ViewModel @Inject constructor(
    private val insert38UseCase: Insert38UseCase,
    private val delete38UseCase: Delete38UseCase,
    private val getAll38UseCase: GetAll38UseCase,
    private val deleteAll38UseCase: DeleteAll38UseCase,
    private val getRowCount38UseCase: GetRowCount38UseCase
) : ViewModel() {


    private val _photos38 = MutableStateFlow<List<Photo38>>(emptyList())
    val photos38: StateFlow<List<Photo38>> = _photos38

    init {
        viewModelScope.launch {
            getAll38UseCase.photoExecute().collect { photoList ->
                _photos38.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo38: Photo38) {
        viewModelScope.launch(Dispatchers.IO) {
            insert38UseCase.photoExecute(photo38)
        }
    }
    fun deleteNewPhoto(photo38 : Photo38, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete38UseCase.photoExecute(photo38)
                _photos38.value = photos38.value.filterNot { it == photo38 }
                val uri = Uri.parse(photo38.image)
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

    fun deleteAll38Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll38UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll38UseCase.photoExecute()
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
        return getRowCount38UseCase.photoExecute() == 0
    }
}