package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo44
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete44UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll44UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll44UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount44UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert44UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo44ViewModel @Inject constructor(
    private val insert44UseCase: Insert44UseCase,
    private val delete44UseCase: Delete44UseCase,
    private val getAll44UseCase: GetAll44UseCase,
    private val deleteAll44UseCase: DeleteAll44UseCase,
    private val getRowCount44UseCase: GetRowCount44UseCase
) : ViewModel() {


    private val _photos44 = MutableStateFlow<List<Photo44>>(emptyList())
    val photos44: StateFlow<List<Photo44>> = _photos44

    init {
        viewModelScope.launch {
            getAll44UseCase.photoExecute().collect { photoList ->
                _photos44.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo44: Photo44) {
        viewModelScope.launch(Dispatchers.IO) {
            insert44UseCase.photoExecute(photo44)
        }
    }
    fun deleteNewPhoto(photo44 : Photo44, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete44UseCase.photoExecute(photo44)
                _photos44.value = photos44.value.filterNot { it == photo44 }
                val uri = Uri.parse(photo44.image)
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

    fun deleteAll44Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll44UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll44UseCase.photoExecute()
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
        return getRowCount44UseCase.photoExecute() == 0
    }
}