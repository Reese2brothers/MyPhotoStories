package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo85
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete85UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll85UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll85UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount85UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert85UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo85ViewModel @Inject constructor(
    private val insert85UseCase: Insert85UseCase,
    private val delete85UseCase: Delete85UseCase,
    private val getAll85UseCase: GetAll85UseCase,
    private val deleteAll85UseCase: DeleteAll85UseCase,
    private val getRowCount85UseCase: GetRowCount85UseCase
) : ViewModel() {


    private val _photos85 = MutableStateFlow<List<Photo85>>(emptyList())
    val photos85: StateFlow<List<Photo85>> = _photos85

    init {
        viewModelScope.launch {
            getAll85UseCase.photoExecute().collect { photoList ->
                _photos85.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo85: Photo85) {
        viewModelScope.launch(Dispatchers.IO) {
            insert85UseCase.photoExecute(photo85)
        }
    }
    fun deleteNewPhoto(photo85 : Photo85, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete85UseCase.photoExecute(photo85)
                _photos85.value = photos85.value.filterNot { it == photo85 }
                val uri = Uri.parse(photo85.image)
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
    fun deleteAll85Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll85UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll85UseCase.photoExecute()
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
        return getRowCount85UseCase.photoExecute() == 0
    }
}