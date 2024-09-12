package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo70
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete70UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll70UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll70UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount70UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert70UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo70ViewModel @Inject constructor(
    private val insert70UseCase: Insert70UseCase,
    private val delete70UseCase: Delete70UseCase,
    private val getAll70UseCase: GetAll70UseCase,
    private val deleteAll70UseCase: DeleteAll70UseCase,
    private val getRowCount70UseCase: GetRowCount70UseCase
) : ViewModel() {


    private val _photos70 = MutableStateFlow<List<Photo70>>(emptyList())
    val photos70: StateFlow<List<Photo70>> = _photos70

    init {
        viewModelScope.launch {
            getAll70UseCase.photoExecute().collect { photoList ->
                _photos70.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo70: Photo70) {
        viewModelScope.launch(Dispatchers.IO) {
            insert70UseCase.photoExecute(photo70)
        }
    }
    fun deleteNewPhoto(photo70 : Photo70, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete70UseCase.photoExecute(photo70)
                _photos70.value = photos70.value.filterNot { it == photo70 }
                val uri = Uri.parse(photo70.image)
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
    fun deleteAll70Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll70UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll70UseCase.photoExecute()
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
        return getRowCount70UseCase.photoExecute() == 0
    }
}