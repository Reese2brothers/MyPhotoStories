package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo50
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete50UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll50UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll50UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount50UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert50UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo50ViewModel @Inject constructor(
    private val insert50UseCase: Insert50UseCase,
    private val delete50UseCase: Delete50UseCase,
    private val getAll50UseCase: GetAll50UseCase,
    private val deleteAll50UseCase: DeleteAll50UseCase,
    private val getRowCount50UseCase: GetRowCount50UseCase
) : ViewModel() {


    private val _photos50 = MutableStateFlow<List<Photo50>>(emptyList())
    val photos50: StateFlow<List<Photo50>> = _photos50

    init {
        viewModelScope.launch {
            getAll50UseCase.photoExecute().collect { photoList ->
                _photos50.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo50: Photo50) {
        viewModelScope.launch(Dispatchers.IO) {
            insert50UseCase.photoExecute(photo50)
        }
    }
    fun deleteNewPhoto(photo50 : Photo50, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete50UseCase.photoExecute(photo50)
                _photos50.value = photos50.value.filterNot { it == photo50 }
                val uri = Uri.parse(photo50.image)
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

    fun deleteAll50Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll50UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll50UseCase.photoExecute()
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
        return getRowCount50UseCase.photoExecute() == 0
    }
}