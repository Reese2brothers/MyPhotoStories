package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo72
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete72UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll72UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll72UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount72UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert72UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo72ViewModel @Inject constructor(
    private val insert72UseCase: Insert72UseCase,
    private val delete72UseCase: Delete72UseCase,
    private val getAll72UseCase: GetAll72UseCase,
    private val deleteAll72UseCase: DeleteAll72UseCase,
    private val getRowCount72UseCase: GetRowCount72UseCase
) : ViewModel() {


    private val _photos72 = MutableStateFlow<List<Photo72>>(emptyList())
    val photos72: StateFlow<List<Photo72>> = _photos72

    init {
        viewModelScope.launch {
            getAll72UseCase.photoExecute().collect { photoList ->
                _photos72.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo72: Photo72) {
        viewModelScope.launch(Dispatchers.IO) {
            insert72UseCase.photoExecute(photo72)
        }
    }
    fun deleteNewPhoto(photo72 : Photo72, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete72UseCase.photoExecute(photo72)
                _photos72.value = photos72.value.filterNot { it == photo72 }
                val uri = Uri.parse(photo72.image)
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
    fun deleteAll72Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll72UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll72UseCase.photoExecute()
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
        return getRowCount72UseCase.photoExecute() == 0
    }
}