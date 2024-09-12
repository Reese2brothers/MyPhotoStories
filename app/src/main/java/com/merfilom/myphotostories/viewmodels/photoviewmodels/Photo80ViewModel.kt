package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo80
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete80UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll80UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll80UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount80UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert80UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo80ViewModel @Inject constructor(
    private val insert80UseCase: Insert80UseCase,
    private val delete80UseCase: Delete80UseCase,
    private val getAll80UseCase: GetAll80UseCase,
    private val deleteAll80UseCase: DeleteAll80UseCase,
    private val getRowCount80UseCase: GetRowCount80UseCase
) : ViewModel() {


    private val _photos80 = MutableStateFlow<List<Photo80>>(emptyList())
    val photos80: StateFlow<List<Photo80>> = _photos80

    init {
        viewModelScope.launch {
            getAll80UseCase.photoExecute().collect { photoList ->
                _photos80.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo80: Photo80) {
        viewModelScope.launch(Dispatchers.IO) {
            insert80UseCase.photoExecute(photo80)
        }
    }
    fun deleteNewPhoto(photo80 : Photo80, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete80UseCase.photoExecute(photo80)
                _photos80.value = photos80.value.filterNot { it == photo80 }
                val uri = Uri.parse(photo80.image)
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
    fun deleteAll80Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll80UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll80UseCase.photoExecute()
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
        return getRowCount80UseCase.photoExecute() == 0
    }
}