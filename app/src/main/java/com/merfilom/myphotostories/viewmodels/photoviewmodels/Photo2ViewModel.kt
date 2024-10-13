package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete2UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll2UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll2UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount2UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert2UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo2ViewModel @Inject constructor(
    private val insert2UseCase: Insert2UseCase,
    private val delete2UseCase: Delete2UseCase,
    private val getAll2UseCase: GetAll2UseCase,
    private val deleteAll2UseCase: DeleteAll2UseCase,
    private val getRowCount2UseCase: GetRowCount2UseCase
) : ViewModel() {


    private val _photos2 = MutableStateFlow<List<Photo2>>(emptyList())
    val photos2: StateFlow<List<Photo2>> = _photos2

    init {
        viewModelScope.launch {
            getAll2UseCase.photoExecute().collect { photoList ->
                _photos2.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo2: Photo2) {
        viewModelScope.launch(Dispatchers.IO) {
            insert2UseCase.photoExecute(photo2)
        }
    }
    fun deleteNewPhoto(photo2 : Photo2, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete2UseCase.photoExecute(photo2)
                _photos2.value = photos2.value.filterNot { it == photo2 }
                val uri = Uri.parse(photo2.image)
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
    fun deleteAll2Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll2UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll2UseCase.photoExecute()
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
        return getRowCount2UseCase.photoExecute() == 0
    }
}