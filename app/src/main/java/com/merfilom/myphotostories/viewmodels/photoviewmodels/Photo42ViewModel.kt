package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo42
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete42UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll42UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll42UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount42UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert42UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo42ViewModel @Inject constructor(
    private val insert42UseCase: Insert42UseCase,
    private val delete42UseCase: Delete42UseCase,
    private val getAll42UseCase: GetAll42UseCase,
    private val deleteAll42UseCase: DeleteAll42UseCase,
    private val getRowCount42UseCase: GetRowCount42UseCase
) : ViewModel() {


    private val _photos42 = MutableStateFlow<List<Photo42>>(emptyList())
    val photos42: StateFlow<List<Photo42>> = _photos42

    init {
        viewModelScope.launch {
            getAll42UseCase.photoExecute().collect { photoList ->
                _photos42.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo42: Photo42) {
        viewModelScope.launch(Dispatchers.IO) {
            insert42UseCase.photoExecute(photo42)
        }
    }
    fun deleteNewPhoto(photo42 : Photo42, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete42UseCase.photoExecute(photo42)
                _photos42.value = photos42.value.filterNot { it == photo42 }
                val uri = Uri.parse(photo42.image)
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

    fun deleteAll42Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll42UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll42UseCase.photoExecute()
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
        return getRowCount42UseCase.photoExecute() == 0
    }
}