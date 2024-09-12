package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo12
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete12UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll12UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll12UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount12UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert12UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo12ViewModel @Inject constructor(
    private val insert12UseCase: Insert12UseCase,
    private val delete12UseCase: Delete12UseCase,
    private val getAll12UseCase: GetAll12UseCase,
    private val deleteAll12UseCase: DeleteAll12UseCase,
    private val getRowCount12UseCase: GetRowCount12UseCase
) : ViewModel() {


    private val _photos12 = MutableStateFlow<List<Photo12>>(emptyList())
    val photos12: StateFlow<List<Photo12>> = _photos12

    init {
        viewModelScope.launch {
            getAll12UseCase.photoExecute().collect { photoList ->
                _photos12.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo12: Photo12) {
        viewModelScope.launch(Dispatchers.IO) {
            insert12UseCase.photoExecute(photo12)
        }
    }
    fun deleteNewPhoto(photo12 : Photo12, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete12UseCase.photoExecute(photo12)
                _photos12.value = photos12.value.filterNot { it == photo12 }
                val uri = Uri.parse(photo12.image)
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
    fun deleteAll12Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll12UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll12UseCase.photoExecute()
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
        return getRowCount12UseCase.photoExecute() == 0
    }
}