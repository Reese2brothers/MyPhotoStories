package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo100
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete100UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll100UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll100UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount100UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert100UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo100ViewModel @Inject constructor(
    private val insert100UseCase: Insert100UseCase,
    private val delete100UseCase: Delete100UseCase,
    private val getAll100UseCase: GetAll100UseCase,
    private val deleteAll100UseCase: DeleteAll100UseCase,
    private val getRowCount100UseCase: GetRowCount100UseCase
) : ViewModel() {


    private val _photos100 = MutableStateFlow<List<Photo100>>(emptyList())
    val photos100: StateFlow<List<Photo100>> = _photos100

    init {
        viewModelScope.launch {
            getAll100UseCase.photoExecute().collect { photoList ->
                _photos100.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo100: Photo100) {
        viewModelScope.launch(Dispatchers.IO) {
            insert100UseCase.photoExecute(photo100)
        }
    }
    fun deleteNewPhoto(photo100 : Photo100, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete100UseCase.photoExecute(photo100)
                _photos100.value = photos100.value.filterNot { it == photo100 }
                val uri = Uri.parse(photo100.image)
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
    fun deleteAll100Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll100UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll100UseCase.photoExecute()
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
        return getRowCount100UseCase.photoExecute() == 0
    }
}