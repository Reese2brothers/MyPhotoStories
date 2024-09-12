package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo64
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete64UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll64UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll64UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount64UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert64UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo64ViewModel @Inject constructor(
    private val insert64UseCase: Insert64UseCase,
    private val delete64UseCase: Delete64UseCase,
    private val getAll64UseCase: GetAll64UseCase,
    private val deleteAll64UseCase: DeleteAll64UseCase,
    private val getRowCount64UseCase: GetRowCount64UseCase
) : ViewModel() {


    private val _photos64 = MutableStateFlow<List<Photo64>>(emptyList())
    val photos64: StateFlow<List<Photo64>> = _photos64

    init {
        viewModelScope.launch {
            getAll64UseCase.photoExecute().collect { photoList ->
                _photos64.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo64: Photo64) {
        viewModelScope.launch(Dispatchers.IO) {
            insert64UseCase.photoExecute(photo64)
        }
    }
    fun deleteNewPhoto(photo64 : Photo64, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete64UseCase.photoExecute(photo64)
                _photos64.value = photos64.value.filterNot { it == photo64 }
                val uri = Uri.parse(photo64.image)
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
    fun deleteAll64Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll64UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll64UseCase.photoExecute()
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
        return getRowCount64UseCase.photoExecute() == 0
    }
}