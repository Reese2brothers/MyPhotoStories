package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo94
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete94UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll94UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll94UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount94UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert94UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo94ViewModel @Inject constructor(
    private val insert94UseCase: Insert94UseCase,
    private val delete94UseCase: Delete94UseCase,
    private val getAll94UseCase: GetAll94UseCase,
    private val deleteAll94UseCase: DeleteAll94UseCase,
    private val getRowCount94UseCase: GetRowCount94UseCase
) : ViewModel() {


    private val _photos94 = MutableStateFlow<List<Photo94>>(emptyList())
    val photos94: StateFlow<List<Photo94>> = _photos94

    init {
        viewModelScope.launch {
            getAll94UseCase.photoExecute().collect { photoList ->
                _photos94.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo94: Photo94) {
        viewModelScope.launch(Dispatchers.IO) {
            insert94UseCase.photoExecute(photo94)
        }
    }
    fun deleteNewPhoto(photo94 : Photo94, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete94UseCase.photoExecute(photo94)
                _photos94.value = photos94.value.filterNot { it == photo94 }
                val uri = Uri.parse(photo94.image)
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
    fun deleteAll94Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll94UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll94UseCase.photoExecute()
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
        return getRowCount94UseCase.photoExecute() == 0
    }
}