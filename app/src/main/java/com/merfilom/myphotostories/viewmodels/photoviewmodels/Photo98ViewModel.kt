package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo98
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete98UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll98UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll98UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount98UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert98UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo98ViewModel @Inject constructor(
    private val insert98UseCase: Insert98UseCase,
    private val delete98UseCase: Delete98UseCase,
    private val getAll98UseCase: GetAll98UseCase,
    private val deleteAll98UseCase: DeleteAll98UseCase,
    private val getRowCount98UseCase: GetRowCount98UseCase
) : ViewModel() {


    private val _photos98 = MutableStateFlow<List<Photo98>>(emptyList())
    val photos98: StateFlow<List<Photo98>> = _photos98

    init {
        viewModelScope.launch {
            getAll98UseCase.photoExecute().collect { photoList ->
                _photos98.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo98: Photo98) {
        viewModelScope.launch(Dispatchers.IO) {
            insert98UseCase.photoExecute(photo98)
        }
    }
    fun deleteNewPhoto(photo98 : Photo98, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete98UseCase.photoExecute(photo98)
                _photos98.value = photos98.value.filterNot { it == photo98 }
                val uri = Uri.parse(photo98.image)
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
    fun deleteAll98Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll98UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll98UseCase.photoExecute()
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
        return getRowCount98UseCase.photoExecute() == 0
    }
}