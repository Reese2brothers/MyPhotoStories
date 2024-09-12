package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo24
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete24UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll24UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll24UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount24UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert24UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo24ViewModel @Inject constructor(
    private val insert24UseCase: Insert24UseCase,
    private val delete24UseCase: Delete24UseCase,
    private val getAll24UseCase: GetAll24UseCase,
    private val deleteAll24UseCase: DeleteAll24UseCase,
    private val getRowCount24UseCase: GetRowCount24UseCase
) : ViewModel() {


    private val _photos24 = MutableStateFlow<List<Photo24>>(emptyList())
    val photos24: StateFlow<List<Photo24>> = _photos24

    init {
        viewModelScope.launch {
            getAll24UseCase.photoExecute().collect { photoList ->
                _photos24.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo24: Photo24) {
        viewModelScope.launch(Dispatchers.IO) {
            insert24UseCase.photoExecute(photo24)
        }
    }
    fun deleteNewPhoto(photo24 : Photo24, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete24UseCase.photoExecute(photo24)
                _photos24.value = photos24.value.filterNot { it == photo24 }
                val uri = Uri.parse(photo24.image)
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

    fun deleteAll24Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll24UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll24UseCase.photoExecute()
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
        return getRowCount24UseCase.photoExecute() == 0
    }
}