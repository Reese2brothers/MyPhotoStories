package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo9
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete9UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll9UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll9UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount9UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert9UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo9ViewModel @Inject constructor(
    private val insert9UseCase: Insert9UseCase,
    private val delete9UseCase: Delete9UseCase,
    private val getAll9UseCase: GetAll9UseCase,
    private val deleteAll9UseCase: DeleteAll9UseCase,
    private val getRowCount9UseCase: GetRowCount9UseCase
) : ViewModel() {


    private val _photos9 = MutableStateFlow<List<Photo9>>(emptyList())
    val photos9: StateFlow<List<Photo9>> = _photos9

    init {
        viewModelScope.launch {
            getAll9UseCase.photoExecute().collect { photoList ->
                _photos9.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo9: Photo9) {
        viewModelScope.launch(Dispatchers.IO) {
            insert9UseCase.photoExecute(photo9)
        }
    }
    fun deleteNewPhoto(photo9 : Photo9, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete9UseCase.photoExecute(photo9)
                _photos9.value = photos9.value.filterNot { it == photo9 }
                val uri = Uri.parse(photo9.image)
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
    fun deleteAll9Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll9UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll9UseCase.photoExecute()
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
        return getRowCount9UseCase.photoExecute() == 0
    }
}