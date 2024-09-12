package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo99
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete99UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll99UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll99UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount99UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert99UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo99ViewModel @Inject constructor(
    private val insert99UseCase: Insert99UseCase,
    private val delete99UseCase: Delete99UseCase,
    private val getAll99UseCase: GetAll99UseCase,
    private val deleteAll99UseCase: DeleteAll99UseCase,
    private val getRowCount99UseCase: GetRowCount99UseCase
) : ViewModel() {


    private val _photos99 = MutableStateFlow<List<Photo99>>(emptyList())
    val photos99: StateFlow<List<Photo99>> = _photos99

    init {
        viewModelScope.launch {
            getAll99UseCase.photoExecute().collect { photoList ->
                _photos99.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo99: Photo99) {
        viewModelScope.launch(Dispatchers.IO) {
            insert99UseCase.photoExecute(photo99)
        }
    }
    fun deleteNewPhoto(photo99 : Photo99, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete99UseCase.photoExecute(photo99)
                _photos99.value = photos99.value.filterNot { it == photo99 }
                val uri = Uri.parse(photo99.image)
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
    fun deleteAll99Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll99UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll99UseCase.photoExecute()
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
        return getRowCount99UseCase.photoExecute() == 0
    }
}