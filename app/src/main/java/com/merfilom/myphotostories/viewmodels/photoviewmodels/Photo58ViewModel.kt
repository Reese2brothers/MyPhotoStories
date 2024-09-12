package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo58
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete58UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll58UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll58UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount58UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert58UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo58ViewModel @Inject constructor(
    private val insert58UseCase: Insert58UseCase,
    private val delete58UseCase: Delete58UseCase,
    private val getAll58UseCase: GetAll58UseCase,
    private val deleteAll58UseCase: DeleteAll58UseCase,
    private val getRowCount58UseCase: GetRowCount58UseCase
) : ViewModel() {


    private val _photos58 = MutableStateFlow<List<Photo58>>(emptyList())
    val photos58: StateFlow<List<Photo58>> = _photos58

    init {
        viewModelScope.launch {
            getAll58UseCase.photoExecute().collect { photoList ->
                _photos58.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo58: Photo58) {
        viewModelScope.launch(Dispatchers.IO) {
            insert58UseCase.photoExecute(photo58)
        }
    }
    fun deleteNewPhoto(photo58 : Photo58, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete58UseCase.photoExecute(photo58)
                _photos58.value = photos58.value.filterNot { it == photo58 }
                val uri = Uri.parse(photo58.image)
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
    fun deleteAll58Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll58UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll58UseCase.photoExecute()
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
        return getRowCount58UseCase.photoExecute() == 0
    }
}