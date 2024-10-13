package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete3UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll3UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll3UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount3UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert3UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo3ViewModel @Inject constructor(
    private val insert3UseCase: Insert3UseCase,
    private val delete3UseCase: Delete3UseCase,
    private val getAll3UseCase: GetAll3UseCase,
    private val deleteAll3UseCase: DeleteAll3UseCase,
    private val getRowCount3UseCase: GetRowCount3UseCase
) : ViewModel() {


    private val _photos3 = MutableStateFlow<List<Photo3>>(emptyList())
    val photos3: StateFlow<List<Photo3>> = _photos3

    init {
        viewModelScope.launch {
            getAll3UseCase.photoExecute().collect { photoList ->
                _photos3.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo3: Photo3) {
        viewModelScope.launch(Dispatchers.IO) {
            insert3UseCase.photoExecute(photo3)
        }
    }
    fun deleteNewPhoto(photo3 : Photo3, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete3UseCase.photoExecute(photo3)
                _photos3.value = photos3.value.filterNot { it == photo3 }
                val uri = Uri.parse(photo3.image)
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
    fun deleteAll3Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll3UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll3UseCase.photoExecute()
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
        return getRowCount3UseCase.photoExecute() == 0
    }
}