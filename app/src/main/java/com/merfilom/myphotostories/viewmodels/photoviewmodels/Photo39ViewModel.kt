package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo39
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete39UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll39UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll39UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount39UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert39UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo39ViewModel @Inject constructor(
    private val insert39UseCase: Insert39UseCase,
    private val delete39UseCase: Delete39UseCase,
    private val getAll39UseCase: GetAll39UseCase,
    private val deleteAll39UseCase: DeleteAll39UseCase,
    private val getRowCount39UseCase: GetRowCount39UseCase
) : ViewModel() {


    private val _photos39 = MutableStateFlow<List<Photo39>>(emptyList())
    val photos39: StateFlow<List<Photo39>> = _photos39

    init {
        viewModelScope.launch {
            getAll39UseCase.photoExecute().collect { photoList ->
                _photos39.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo39: Photo39) {
        viewModelScope.launch(Dispatchers.IO) {
            insert39UseCase.photoExecute(photo39)
        }
    }
    fun deleteNewPhoto(photo39 : Photo39, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete39UseCase.photoExecute(photo39)
                _photos39.value = photos39.value.filterNot { it == photo39 }
                val uri = Uri.parse(photo39.image)
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

    fun deleteAll39Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll39UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll39UseCase.photoExecute()
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
        return getRowCount39UseCase.photoExecute() == 0
    }
}