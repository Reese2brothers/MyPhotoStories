package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo79
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete79UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll79UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll79UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount79UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert79UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo79ViewModel @Inject constructor(
    private val insert79UseCase: Insert79UseCase,
    private val delete79UseCase: Delete79UseCase,
    private val getAll79UseCase: GetAll79UseCase,
    private val deleteAll79UseCase: DeleteAll79UseCase,
    private val getRowCount79UseCase: GetRowCount79UseCase
) : ViewModel() {


    private val _photos79 = MutableStateFlow<List<Photo79>>(emptyList())
    val photos79: StateFlow<List<Photo79>> = _photos79

    init {
        viewModelScope.launch {
            getAll79UseCase.photoExecute().collect { photoList ->
                _photos79.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo79: Photo79) {
        viewModelScope.launch(Dispatchers.IO) {
            insert79UseCase.photoExecute(photo79)
        }
    }
    fun deleteNewPhoto(photo79 : Photo79, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete79UseCase.photoExecute(photo79)
                _photos79.value = photos79.value.filterNot { it == photo79 }
                val uri = Uri.parse(photo79.image)
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
    fun deleteAll79Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll79UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll79UseCase.photoExecute()
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
        return getRowCount79UseCase.photoExecute() == 0
    }
}