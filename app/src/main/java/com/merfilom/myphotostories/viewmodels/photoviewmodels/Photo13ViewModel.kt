package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo13
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete13UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll13UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll13UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount13UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert13UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo13ViewModel @Inject constructor(
    private val insert13UseCase: Insert13UseCase,
    private val delete13UseCase: Delete13UseCase,
    private val getAll13UseCase: GetAll13UseCase,
    private val deleteAll13UseCase: DeleteAll13UseCase,
    private val getRowCount13UseCase: GetRowCount13UseCase
) : ViewModel() {


    private val _photos13 = MutableStateFlow<List<Photo13>>(emptyList())
    val photos13: StateFlow<List<Photo13>> = _photos13

    init {
        viewModelScope.launch {
            getAll13UseCase.photoExecute().collect { photoList ->
                _photos13.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo13: Photo13) {
        viewModelScope.launch(Dispatchers.IO) {
            insert13UseCase.photoExecute(photo13)
        }
    }
    fun deleteNewPhoto(photo13 : Photo13, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete13UseCase.photoExecute(photo13)
                _photos13.value = photos13.value.filterNot { it == photo13 }
                val uri = Uri.parse(photo13.image)
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
    fun deleteAll13Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll13UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll13UseCase.photoExecute()
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
        return getRowCount13UseCase.photoExecute() == 0
    }
}