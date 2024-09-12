package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo86
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete86UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll86UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll86UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount86UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert86UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo86ViewModel @Inject constructor(
    private val insert86UseCase: Insert86UseCase,
    private val delete86UseCase: Delete86UseCase,
    private val getAll86UseCase: GetAll86UseCase,
    private val deleteAll86UseCase: DeleteAll86UseCase,
    private val getRowCount86UseCase: GetRowCount86UseCase
) : ViewModel() {


    private val _photos86 = MutableStateFlow<List<Photo86>>(emptyList())
    val photos86: StateFlow<List<Photo86>> = _photos86

    init {
        viewModelScope.launch {
            getAll86UseCase.photoExecute().collect { photoList ->
                _photos86.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo86: Photo86) {
        viewModelScope.launch(Dispatchers.IO) {
            insert86UseCase.photoExecute(photo86)
        }
    }
    fun deleteNewPhoto(photo86 : Photo86, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete86UseCase.photoExecute(photo86)
                _photos86.value = photos86.value.filterNot { it == photo86 }
                val uri = Uri.parse(photo86.image)
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
    fun deleteAll86Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll86UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll86UseCase.photoExecute()
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
        return getRowCount86UseCase.photoExecute() == 0
    }
}