package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo31
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete31UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll31UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll31UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount31UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert31UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo31ViewModel @Inject constructor(
    private val insert31UseCase: Insert31UseCase,
    private val delete31UseCase: Delete31UseCase,
    private val getAll31UseCase: GetAll31UseCase,
    private val deleteAll31UseCase: DeleteAll31UseCase,
    private val getRowCount31UseCase: GetRowCount31UseCase
) : ViewModel() {


    private val _photos31 = MutableStateFlow<List<Photo31>>(emptyList())
    val photos31: StateFlow<List<Photo31>> = _photos31

    init {
        viewModelScope.launch {
            getAll31UseCase.photoExecute().collect { photoList ->
                _photos31.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo31: Photo31) {
        viewModelScope.launch(Dispatchers.IO) {
            insert31UseCase.photoExecute(photo31)
        }
    }
    fun deleteNewPhoto(photo31 : Photo31, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete31UseCase.photoExecute(photo31)
                _photos31.value = photos31.value.filterNot { it == photo31 }
                val uri = Uri.parse(photo31.image)
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

    fun deleteAll31Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll31UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll31UseCase.photoExecute()
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
        return getRowCount31UseCase.photoExecute() == 0
    }
}