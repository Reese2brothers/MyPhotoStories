package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo96
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete96UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll96UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll96UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount96UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert96UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo96ViewModel @Inject constructor(
    private val insert96UseCase: Insert96UseCase,
    private val delete96UseCase: Delete96UseCase,
    private val getAll96UseCase: GetAll96UseCase,
    private val deleteAll96UseCase: DeleteAll96UseCase,
    private val getRowCount96UseCase: GetRowCount96UseCase
) : ViewModel() {


    private val _photos96 = MutableStateFlow<List<Photo96>>(emptyList())
    val photos96: StateFlow<List<Photo96>> = _photos96

    init {
        viewModelScope.launch {
            getAll96UseCase.photoExecute().collect { photoList ->
                _photos96.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo96: Photo96) {
        viewModelScope.launch(Dispatchers.IO) {
            insert96UseCase.photoExecute(photo96)
        }
    }
    fun deleteNewPhoto(photo96 : Photo96, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete96UseCase.photoExecute(photo96)
                _photos96.value = photos96.value.filterNot { it == photo96 }
                val uri = Uri.parse(photo96.image)
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
    fun deleteAll96Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll96UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll96UseCase.photoExecute()
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
        return getRowCount96UseCase.photoExecute() == 0
    }
}