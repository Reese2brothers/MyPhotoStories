package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo30
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete30UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll30UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll30UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount30UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert30UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo30ViewModel @Inject constructor(
    private val insert30UseCase: Insert30UseCase,
    private val delete30UseCase: Delete30UseCase,
    private val getAll30UseCase: GetAll30UseCase,
    private val deleteAll30UseCase: DeleteAll30UseCase,
    private val getRowCount30UseCase: GetRowCount30UseCase
) : ViewModel() {


    private val _photos30 = MutableStateFlow<List<Photo30>>(emptyList())
    val photos30: StateFlow<List<Photo30>> = _photos30

    init {
        viewModelScope.launch {
            getAll30UseCase.photoExecute().collect { photoList ->
                _photos30.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo30: Photo30) {
        viewModelScope.launch(Dispatchers.IO) {
            insert30UseCase.photoExecute(photo30)
        }
    }
    fun deleteNewPhoto(photo30 : Photo30, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete30UseCase.photoExecute(photo30)
                _photos30.value = photos30.value.filterNot { it == photo30 }
                val uri = Uri.parse(photo30.image)
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

    fun deleteAll30Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll30UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll30UseCase.photoExecute()
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
        return getRowCount30UseCase.photoExecute() == 0
    }
}