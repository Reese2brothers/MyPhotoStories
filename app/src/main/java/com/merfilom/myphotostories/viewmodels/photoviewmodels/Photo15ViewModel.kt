package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo15
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete15UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll15UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll15UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount15UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert15UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo15ViewModel @Inject constructor(
    private val insert15UseCase: Insert15UseCase,
    private val delete15UseCase: Delete15UseCase,
    private val getAll15UseCase: GetAll15UseCase,
    private val deleteAll15UseCase: DeleteAll15UseCase,
    private val getRowCount15UseCase: GetRowCount15UseCase
) : ViewModel() {


    private val _photos15 = MutableStateFlow<List<Photo15>>(emptyList())
    val photos15: StateFlow<List<Photo15>> = _photos15

    init {
        viewModelScope.launch {
            getAll15UseCase.photoExecute().collect { photoList ->
                _photos15.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo15: Photo15) {
        viewModelScope.launch(Dispatchers.IO) {
            insert15UseCase.photoExecute(photo15)
        }
    }
    fun deleteNewPhoto(photo15 : Photo15, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete15UseCase.photoExecute(photo15)
                _photos15.value = photos15.value.filterNot { it == photo15 }
                val uri = Uri.parse(photo15.image)
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
    fun deleteAll15Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll15UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll15UseCase.photoExecute()
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
        return getRowCount15UseCase.photoExecute() == 0
    }
}