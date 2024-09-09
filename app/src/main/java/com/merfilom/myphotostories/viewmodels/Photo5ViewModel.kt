package com.merfilom.myphotostories.viewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.usecases.Delete5UseCase
import com.merfilom.myphotostories.domain.usecases.DeleteAll5UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll5UseCase
import com.merfilom.myphotostories.domain.usecases.GetRowCount5UseCase
import com.merfilom.myphotostories.domain.usecases.Insert5UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo5ViewModel @Inject constructor(
    private val insert5UseCase: Insert5UseCase,
    private val delete5UseCase: Delete5UseCase,
    private val getAll5UseCase: GetAll5UseCase,
    private val deleteAll5UseCase: DeleteAll5UseCase,
    private val getRowCount5UseCase: GetRowCount5UseCase
) : ViewModel() {


    private val _photos5 = MutableStateFlow<List<Photo5>>(emptyList())
    val photos5: StateFlow<List<Photo5>> = _photos5

    init {
        viewModelScope.launch {
            getAll5UseCase.photoExecute().collect { photoList ->
                _photos5.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo5: Photo5) {
        viewModelScope.launch(Dispatchers.IO) {
            insert5UseCase.photoExecute(photo5)
        }
    }
    fun deleteNewPhoto(photo5 : Photo5, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete5UseCase.photoExecute(photo5)
                _photos5.value = photos5.value.filterNot { it == photo5 }
                val uri = Uri.parse(photo5.image)
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
    fun getAll5NewPhoto(): List<Photo5>  {
        var photoList = emptyList<Photo5>()
        viewModelScope.launch {
            getAll5UseCase.photoExecute().collect { list ->
                photoList = list
            }
        }
        return photoList
    }
    fun deleteAll5Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll5UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll5UseCase.photoExecute()
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
        return getRowCount5UseCase.photoExecute() == 0
    }
}