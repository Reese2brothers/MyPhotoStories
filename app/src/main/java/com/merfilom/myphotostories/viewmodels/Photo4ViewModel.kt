package com.merfilom.myphotostories.viewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.usecases.Delete4UseCase
import com.merfilom.myphotostories.domain.usecases.DeleteAll4UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll4UseCase
import com.merfilom.myphotostories.domain.usecases.GetRowCount4UseCase
import com.merfilom.myphotostories.domain.usecases.Insert4UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo4ViewModel @Inject constructor(
    private val insert4UseCase: Insert4UseCase,
    private val delete4UseCase: Delete4UseCase,
    private val getAll4UseCase: GetAll4UseCase,
    private val deleteAll4UseCase: DeleteAll4UseCase,
    private val getRowCount4UseCase: GetRowCount4UseCase
) : ViewModel() {


    private val _photos4 = MutableStateFlow<List<Photo4>>(emptyList())
    val photos4: StateFlow<List<Photo4>> = _photos4

    init {
        viewModelScope.launch {
            getAll4UseCase.photoExecute().collect { photoList ->
                _photos4.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo4: Photo4) {
        viewModelScope.launch(Dispatchers.IO) {
            insert4UseCase.photoExecute(photo4)
        }
    }
    fun deleteNewPhoto(photo4 : Photo4, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete4UseCase.photoExecute(photo4)
                _photos4.value = photos4.value.filterNot { it == photo4 }
                val uri = Uri.parse(photo4.image)
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
    fun getAll4NewPhoto(): List<Photo4>  {
        var photoList = emptyList<Photo4>()
        viewModelScope.launch {
            getAll4UseCase.photoExecute().collect { list ->
                photoList = list
            }
        }
        return photoList
    }
    fun deleteAll4Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll4UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll4UseCase.photoExecute()
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
        return getRowCount4UseCase.photoExecute() == 0
    }
}