package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo22
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete22UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll22UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll22UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount22UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert22UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo22ViewModel @Inject constructor(
    private val insert22UseCase: Insert22UseCase,
    private val delete22UseCase: Delete22UseCase,
    private val getAll22UseCase: GetAll22UseCase,
    private val deleteAll22UseCase: DeleteAll22UseCase,
    private val getRowCount22UseCase: GetRowCount22UseCase
) : ViewModel() {


    private val _photos22 = MutableStateFlow<List<Photo22>>(emptyList())
    val photos22: StateFlow<List<Photo22>> = _photos22

    init {
        viewModelScope.launch {
            getAll22UseCase.photoExecute().collect { photoList ->
                _photos22.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo22: Photo22) {
        viewModelScope.launch(Dispatchers.IO) {
            insert22UseCase.photoExecute(photo22)
        }
    }
    fun deleteNewPhoto(photo22 : Photo22, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete22UseCase.photoExecute(photo22)
                _photos22.value = photos22.value.filterNot { it == photo22 }
                val uri = Uri.parse(photo22.image)
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

    fun deleteAll22Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll22UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll22UseCase.photoExecute()
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
        return getRowCount22UseCase.photoExecute() == 0
    }
}