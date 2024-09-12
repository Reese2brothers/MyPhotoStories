package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo56
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete56UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll56UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll56UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount56UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert56UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo56ViewModel @Inject constructor(
    private val insert56UseCase: Insert56UseCase,
    private val delete56UseCase: Delete56UseCase,
    private val getAll56UseCase: GetAll56UseCase,
    private val deleteAll56UseCase: DeleteAll56UseCase,
    private val getRowCount56UseCase: GetRowCount56UseCase
) : ViewModel() {


    private val _photos56 = MutableStateFlow<List<Photo56>>(emptyList())
    val photos56: StateFlow<List<Photo56>> = _photos56

    init {
        viewModelScope.launch {
            getAll56UseCase.photoExecute().collect { photoList ->
                _photos56.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo56: Photo56) {
        viewModelScope.launch(Dispatchers.IO) {
            insert56UseCase.photoExecute(photo56)
        }
    }
    fun deleteNewPhoto(photo56: Photo56, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete56UseCase.photoExecute(photo56)
                _photos56.value = photos56.value.filterNot { it == photo56 }
                val uri = Uri.parse(photo56.image)
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
    fun deleteAll56Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll56UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll56UseCase.photoExecute()
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
        return getRowCount56UseCase.photoExecute() == 0
    }
}