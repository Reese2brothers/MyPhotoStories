package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo14
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete14UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll14UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll14UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount14UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert14UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo14ViewModel @Inject constructor(
    private val insert14UseCase: Insert14UseCase,
    private val delete14UseCase: Delete14UseCase,
    private val getAll14UseCase: GetAll14UseCase,
    private val deleteAll14UseCase: DeleteAll14UseCase,
    private val getRowCount14UseCase: GetRowCount14UseCase
) : ViewModel() {


    private val _photos14 = MutableStateFlow<List<Photo14>>(emptyList())
    val photos14: StateFlow<List<Photo14>> = _photos14

    init {
        viewModelScope.launch {
            getAll14UseCase.photoExecute().collect { photoList ->
                _photos14.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo14: Photo14) {
        viewModelScope.launch(Dispatchers.IO) {
            insert14UseCase.photoExecute(photo14)
        }
    }
    fun deleteNewPhoto(photo14 : Photo14, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete14UseCase.photoExecute(photo14)
                _photos14.value = photos14.value.filterNot { it == photo14 }
                val uri = Uri.parse(photo14.image)
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
    fun deleteAll14Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll14UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll14UseCase.photoExecute()
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
        return getRowCount14UseCase.photoExecute() == 0
    }
}