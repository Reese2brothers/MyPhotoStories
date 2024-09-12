package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo37
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete37UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll37UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll37UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount37UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert37UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo37ViewModel @Inject constructor(
    private val insert37UseCase: Insert37UseCase,
    private val delete37UseCase: Delete37UseCase,
    private val getAll37UseCase: GetAll37UseCase,
    private val deleteAll37UseCase: DeleteAll37UseCase,
    private val getRowCount37UseCase: GetRowCount37UseCase
) : ViewModel() {


    private val _photos37 = MutableStateFlow<List<Photo37>>(emptyList())
    val photos37: StateFlow<List<Photo37>> = _photos37

    init {
        viewModelScope.launch {
            getAll37UseCase.photoExecute().collect { photoList ->
                _photos37.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo37: Photo37) {
        viewModelScope.launch(Dispatchers.IO) {
            insert37UseCase.photoExecute(photo37)
        }
    }
    fun deleteNewPhoto(photo37 : Photo37, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete37UseCase.photoExecute(photo37)
                _photos37.value = photos37.value.filterNot { it == photo37 }
                val uri = Uri.parse(photo37.image)
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

    fun deleteAll37Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll37UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll37UseCase.photoExecute()
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
        return getRowCount37UseCase.photoExecute() == 0
    }
}