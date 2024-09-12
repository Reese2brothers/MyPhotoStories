package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo87
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete87UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll87UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll87UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount87UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert87UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo87ViewModel @Inject constructor(
    private val insert87UseCase: Insert87UseCase,
    private val delete87UseCase: Delete87UseCase,
    private val getAll87UseCase: GetAll87UseCase,
    private val deleteAll87UseCase: DeleteAll87UseCase,
    private val getRowCount87UseCase: GetRowCount87UseCase
) : ViewModel() {


    private val _photos87 = MutableStateFlow<List<Photo87>>(emptyList())
    val photos87: StateFlow<List<Photo87>> = _photos87

    init {
        viewModelScope.launch {
            getAll87UseCase.photoExecute().collect { photoList ->
                _photos87.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo87: Photo87) {
        viewModelScope.launch(Dispatchers.IO) {
            insert87UseCase.photoExecute(photo87)
        }
    }
    fun deleteNewPhoto(photo87 : Photo87, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete87UseCase.photoExecute(photo87)
                _photos87.value = photos87.value.filterNot { it == photo87 }
                val uri = Uri.parse(photo87.image)
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
    fun deleteAll87Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll87UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll87UseCase.photoExecute()
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
        return getRowCount87UseCase.photoExecute() == 0
    }
}