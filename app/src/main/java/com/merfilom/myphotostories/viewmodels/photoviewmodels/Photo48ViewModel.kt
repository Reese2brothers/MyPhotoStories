package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo48
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete48UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll48UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll48UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount48UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert48UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo48ViewModel @Inject constructor(
    private val insert48UseCase: Insert48UseCase,
    private val delete48UseCase: Delete48UseCase,
    private val getAll48UseCase: GetAll48UseCase,
    private val deleteAll48UseCase: DeleteAll48UseCase,
    private val getRowCount48UseCase: GetRowCount48UseCase
) : ViewModel() {


    private val _photos48 = MutableStateFlow<List<Photo48>>(emptyList())
    val photos48: StateFlow<List<Photo48>> = _photos48

    init {
        viewModelScope.launch {
            getAll48UseCase.photoExecute().collect { photoList ->
                _photos48.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo48: Photo48) {
        viewModelScope.launch(Dispatchers.IO) {
            insert48UseCase.photoExecute(photo48)
        }
    }
    fun deleteNewPhoto(photo48 : Photo48, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete48UseCase.photoExecute(photo48)
                _photos48.value = photos48.value.filterNot { it == photo48 }
                val uri = Uri.parse(photo48.image)
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

    fun deleteAll48Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll48UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll48UseCase.photoExecute()
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
        return getRowCount48UseCase.photoExecute() == 0
    }
}