package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo21
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete21UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll21UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll21UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount21UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert21UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo21ViewModel @Inject constructor(
    private val insert21UseCase: Insert21UseCase,
    private val delete21UseCase: Delete21UseCase,
    private val getAll21UseCase: GetAll21UseCase,
    private val deleteAll21UseCase: DeleteAll21UseCase,
    private val getRowCount21UseCase: GetRowCount21UseCase
) : ViewModel() {


    private val _photos21 = MutableStateFlow<List<Photo21>>(emptyList())
    val photos21: StateFlow<List<Photo21>> = _photos21

    init {
        viewModelScope.launch {
            getAll21UseCase.photoExecute().collect { photoList ->
                _photos21.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo21: Photo21) {
        viewModelScope.launch(Dispatchers.IO) {
            insert21UseCase.photoExecute(photo21)
        }
    }
    fun deleteNewPhoto(photo21 : Photo21, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete21UseCase.photoExecute(photo21)
                _photos21.value = photos21.value.filterNot { it == photo21 }
                val uri = Uri.parse(photo21.image)
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

    fun deleteAll21Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll21UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll21UseCase.photoExecute()
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
        return getRowCount21UseCase.photoExecute() == 0
    }
}