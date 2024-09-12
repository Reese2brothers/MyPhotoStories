package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo18
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete18UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll18UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll18UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount18UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert18UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo18ViewModel @Inject constructor(
    private val insert18UseCase: Insert18UseCase,
    private val delete18UseCase: Delete18UseCase,
    private val getAll18UseCase: GetAll18UseCase,
    private val deleteAll18UseCase: DeleteAll18UseCase,
    private val getRowCount18UseCase: GetRowCount18UseCase
) : ViewModel() {


    private val _photos18 = MutableStateFlow<List<Photo18>>(emptyList())
    val photos18: StateFlow<List<Photo18>> = _photos18

    init {
        viewModelScope.launch {
            getAll18UseCase.photoExecute().collect { photoList ->
                _photos18.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo18: Photo18) {
        viewModelScope.launch(Dispatchers.IO) {
            insert18UseCase.photoExecute(photo18)
        }
    }
    fun deleteNewPhoto(photo18 : Photo18, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete18UseCase.photoExecute(photo18)
                _photos18.value = photos18.value.filterNot { it == photo18 }
                val uri = Uri.parse(photo18.image)
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

    fun deleteAll18Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll18UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll18UseCase.photoExecute()
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
        return getRowCount18UseCase.photoExecute() == 0
    }
}