package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo23
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete23UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll23UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll23UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount23UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert23UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo23ViewModel @Inject constructor(
    private val insert23UseCase: Insert23UseCase,
    private val delete23UseCase: Delete23UseCase,
    private val getAll23UseCase: GetAll23UseCase,
    private val deleteAll23UseCase: DeleteAll23UseCase,
    private val getRowCount23UseCase: GetRowCount23UseCase
) : ViewModel() {


    private val _photos23 = MutableStateFlow<List<Photo23>>(emptyList())
    val photos23: StateFlow<List<Photo23>> = _photos23

    init {
        viewModelScope.launch {
            getAll23UseCase.photoExecute().collect { photoList ->
                _photos23.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo23: Photo23) {
        viewModelScope.launch(Dispatchers.IO) {
            insert23UseCase.photoExecute(photo23)
        }
    }
    fun deleteNewPhoto(photo23 : Photo23, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete23UseCase.photoExecute(photo23)
                _photos23.value = photos23.value.filterNot { it == photo23 }
                val uri = Uri.parse(photo23.image)
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

    fun deleteAll23Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll23UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll23UseCase.photoExecute()
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
        return getRowCount23UseCase.photoExecute() == 0
    }
}