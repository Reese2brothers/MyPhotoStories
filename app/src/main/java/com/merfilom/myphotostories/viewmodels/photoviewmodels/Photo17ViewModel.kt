package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo17
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete17UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll17UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll17UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount17UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert17UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo17ViewModel @Inject constructor(
    private val insert17UseCase: Insert17UseCase,
    private val delete17UseCase: Delete17UseCase,
    private val getAll17UseCase: GetAll17UseCase,
    private val deleteAll17UseCase: DeleteAll17UseCase,
    private val getRowCount17UseCase: GetRowCount17UseCase
) : ViewModel() {


    private val _photos17 = MutableStateFlow<List<Photo17>>(emptyList())
    val photos17: StateFlow<List<Photo17>> = _photos17

    init {
        viewModelScope.launch {
            getAll17UseCase.photoExecute().collect { photoList ->
                _photos17.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo17: Photo17) {
        viewModelScope.launch(Dispatchers.IO) {
            insert17UseCase.photoExecute(photo17)
        }
    }
    fun deleteNewPhoto(photo17 : Photo17, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete17UseCase.photoExecute(photo17)
                _photos17.value = photos17.value.filterNot { it == photo17 }
                val uri = Uri.parse(photo17.image)
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

    fun deleteAll17Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll17UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll17UseCase.photoExecute()
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
        return getRowCount17UseCase.photoExecute() == 0
    }
}