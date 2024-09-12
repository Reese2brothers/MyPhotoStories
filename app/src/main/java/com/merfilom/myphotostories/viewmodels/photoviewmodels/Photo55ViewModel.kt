package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo55
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete55UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll55UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll55UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount55UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert55UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo55ViewModel @Inject constructor(
    private val insert55UseCase: Insert55UseCase,
    private val delete55UseCase: Delete55UseCase,
    private val getAll55UseCase: GetAll55UseCase,
    private val deleteAll55UseCase: DeleteAll55UseCase,
    private val getRowCount55UseCase: GetRowCount55UseCase
) : ViewModel() {


    private val _photos55 = MutableStateFlow<List<Photo55>>(emptyList())
    val photos55: StateFlow<List<Photo55>> = _photos55

    init {
        viewModelScope.launch {
            getAll55UseCase.photoExecute().collect { photoList ->
                _photos55.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo55: Photo55) {
        viewModelScope.launch(Dispatchers.IO) {
            insert55UseCase.photoExecute(photo55)
        }
    }
    fun deleteNewPhoto(photo55 : Photo55, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete55UseCase.photoExecute(photo55)
                _photos55.value = photos55.value.filterNot { it == photo55 }
                val uri = Uri.parse(photo55.image)
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
    fun deleteAll55Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll55UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll55UseCase.photoExecute()
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
        return getRowCount55UseCase.photoExecute() == 0
    }
}