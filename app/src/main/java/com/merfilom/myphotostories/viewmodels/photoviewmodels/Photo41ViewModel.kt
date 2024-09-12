package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo41
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete41UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll41UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll41UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount41UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert41UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo41ViewModel @Inject constructor(
    private val insert41UseCase: Insert41UseCase,
    private val delete41UseCase: Delete41UseCase,
    private val getAll41UseCase: GetAll41UseCase,
    private val deleteAll41UseCase: DeleteAll41UseCase,
    private val getRowCount41UseCase: GetRowCount41UseCase
) : ViewModel() {


    private val _photos41 = MutableStateFlow<List<Photo41>>(emptyList())
    val photos41: StateFlow<List<Photo41>> = _photos41

    init {
        viewModelScope.launch {
            getAll41UseCase.photoExecute().collect { photoList ->
                _photos41.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo41: Photo41) {
        viewModelScope.launch(Dispatchers.IO) {
            insert41UseCase.photoExecute(photo41)
        }
    }
    fun deleteNewPhoto(photo41 : Photo41, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete41UseCase.photoExecute(photo41)
                _photos41.value = photos41.value.filterNot { it == photo41 }
                val uri = Uri.parse(photo41.image)
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

    fun deleteAll41Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll41UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll41UseCase.photoExecute()
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
        return getRowCount41UseCase.photoExecute() == 0
    }
}