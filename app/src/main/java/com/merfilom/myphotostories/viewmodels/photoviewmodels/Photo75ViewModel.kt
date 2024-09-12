package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo75
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete75UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll75UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll75UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount75UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert75UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo75ViewModel @Inject constructor(
    private val insert75UseCase: Insert75UseCase,
    private val delete75UseCase: Delete75UseCase,
    private val getAll75UseCase: GetAll75UseCase,
    private val deleteAll75UseCase: DeleteAll75UseCase,
    private val getRowCount75UseCase: GetRowCount75UseCase
) : ViewModel() {


    private val _photos75 = MutableStateFlow<List<Photo75>>(emptyList())
    val photos75: StateFlow<List<Photo75>> = _photos75

    init {
        viewModelScope.launch {
            getAll75UseCase.photoExecute().collect { photoList ->
                _photos75.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo75: Photo75) {
        viewModelScope.launch(Dispatchers.IO) {
            insert75UseCase.photoExecute(photo75)
        }
    }
    fun deleteNewPhoto(photo75 : Photo75, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete75UseCase.photoExecute(photo75)
                _photos75.value = photos75.value.filterNot { it == photo75 }
                val uri = Uri.parse(photo75.image)
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
    fun deleteAll75Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll75UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll75UseCase.photoExecute()
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
        return getRowCount75UseCase.photoExecute() == 0
    }
}