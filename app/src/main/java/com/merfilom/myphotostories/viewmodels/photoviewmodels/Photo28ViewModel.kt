package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo28
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete28UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll28UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll28UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount28UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert28UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo28ViewModel @Inject constructor(
    private val insert28UseCase: Insert28UseCase,
    private val delete28UseCase: Delete28UseCase,
    private val getAll28UseCase: GetAll28UseCase,
    private val deleteAll28UseCase: DeleteAll28UseCase,
    private val getRowCount28UseCase: GetRowCount28UseCase
) : ViewModel() {


    private val _photos28 = MutableStateFlow<List<Photo28>>(emptyList())
    val photos28: StateFlow<List<Photo28>> = _photos28

    init {
        viewModelScope.launch {
            getAll28UseCase.photoExecute().collect { photoList ->
                _photos28.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo28: Photo28) {
        viewModelScope.launch(Dispatchers.IO) {
            insert28UseCase.photoExecute(photo28)
        }
    }
    fun deleteNewPhoto(photo28 : Photo28, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete28UseCase.photoExecute(photo28)
                _photos28.value = photos28.value.filterNot { it == photo28 }
                val uri = Uri.parse(photo28.image)
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

    fun deleteAll28Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll28UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll28UseCase.photoExecute()
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
        return getRowCount28UseCase.photoExecute() == 0
    }
}