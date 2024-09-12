package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo69
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete69UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll69UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll69UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount69UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert69UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo69ViewModel @Inject constructor(
    private val insert69UseCase: Insert69UseCase,
    private val delete69UseCase: Delete69UseCase,
    private val getAll69UseCase: GetAll69UseCase,
    private val deleteAll69UseCase: DeleteAll69UseCase,
    private val getRowCount69UseCase: GetRowCount69UseCase
) : ViewModel() {


    private val _photos69 = MutableStateFlow<List<Photo69>>(emptyList())
    val photos69: StateFlow<List<Photo69>> = _photos69

    init {
        viewModelScope.launch {
            getAll69UseCase.photoExecute().collect { photoList ->
                _photos69.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo69: Photo69) {
        viewModelScope.launch(Dispatchers.IO) {
            insert69UseCase.photoExecute(photo69)
        }
    }
    fun deleteNewPhoto(photo69 : Photo69, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete69UseCase.photoExecute(photo69)
                _photos69.value = photos69.value.filterNot { it == photo69 }
                val uri = Uri.parse(photo69.image)
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
    fun deleteAll69Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll69UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll69UseCase.photoExecute()
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
        return getRowCount69UseCase.photoExecute() == 0
    }
}