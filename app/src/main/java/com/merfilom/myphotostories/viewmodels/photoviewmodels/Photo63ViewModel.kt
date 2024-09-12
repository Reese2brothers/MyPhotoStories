package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo63
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete63UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll63UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll63UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount63UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert63UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo63ViewModel @Inject constructor(
    private val insert63UseCase: Insert63UseCase,
    private val delete63UseCase: Delete63UseCase,
    private val getAll63UseCase: GetAll63UseCase,
    private val deleteAll63UseCase: DeleteAll63UseCase,
    private val getRowCount63UseCase: GetRowCount63UseCase
) : ViewModel() {


    private val _photos63 = MutableStateFlow<List<Photo63>>(emptyList())
    val photos63: StateFlow<List<Photo63>> = _photos63

    init {
        viewModelScope.launch {
            getAll63UseCase.photoExecute().collect { photoList ->
                _photos63.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo63: Photo63) {
        viewModelScope.launch(Dispatchers.IO) {
            insert63UseCase.photoExecute(photo63)
        }
    }
    fun deleteNewPhoto(photo63 : Photo63, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete63UseCase.photoExecute(photo63)
                _photos63.value = photos63.value.filterNot { it == photo63 }
                val uri = Uri.parse(photo63.image)
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
    fun deleteAll63Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll63UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll63UseCase.photoExecute()
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
        return getRowCount63UseCase.photoExecute() == 0
    }
}