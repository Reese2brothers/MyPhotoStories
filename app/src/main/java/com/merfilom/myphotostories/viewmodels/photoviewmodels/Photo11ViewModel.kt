package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo11
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete11UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll11UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll11UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount11UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert11UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo11ViewModel @Inject constructor(
    private val insert11UseCase: Insert11UseCase,
    private val delete11UseCase: Delete11UseCase,
    private val getAll11UseCase: GetAll11UseCase,
    private val deleteAll11UseCase: DeleteAll11UseCase,
    private val getRowCount11UseCase: GetRowCount11UseCase
) : ViewModel() {


    private val _photos11 = MutableStateFlow<List<Photo11>>(emptyList())
    val photos11: StateFlow<List<Photo11>> = _photos11

    init {
        viewModelScope.launch {
            getAll11UseCase.photoExecute().collect { photoList ->
                _photos11.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo11: Photo11) {
        viewModelScope.launch(Dispatchers.IO) {
            insert11UseCase.photoExecute(photo11)
        }
    }
    fun deleteNewPhoto(photo11 : Photo11, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete11UseCase.photoExecute(photo11)
                _photos11.value = photos11.value.filterNot { it == photo11 }
                val uri = Uri.parse(photo11.image)
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
    fun deleteAll11Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll11UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll11UseCase.photoExecute()
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
        return getRowCount11UseCase.photoExecute() == 0
    }
}