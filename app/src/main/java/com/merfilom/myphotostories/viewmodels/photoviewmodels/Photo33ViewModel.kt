package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo33
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete33UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll33UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll33UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount33UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert33UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo33ViewModel @Inject constructor(
    private val insert33UseCase: Insert33UseCase,
    private val delete33UseCase: Delete33UseCase,
    private val getAll33UseCase: GetAll33UseCase,
    private val deleteAll33UseCase: DeleteAll33UseCase,
    private val getRowCount33UseCase: GetRowCount33UseCase
) : ViewModel() {


    private val _photos33 = MutableStateFlow<List<Photo33>>(emptyList())
    val photos33: StateFlow<List<Photo33>> = _photos33

    init {
        viewModelScope.launch {
            getAll33UseCase.photoExecute().collect { photoList ->
                _photos33.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo33: Photo33) {
        viewModelScope.launch(Dispatchers.IO) {
            insert33UseCase.photoExecute(photo33)
        }
    }
    fun deleteNewPhoto(photo33 : Photo33, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete33UseCase.photoExecute(photo33)
                _photos33.value = photos33.value.filterNot { it == photo33 }
                val uri = Uri.parse(photo33.image)
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

    fun deleteAll33Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll33UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll33UseCase.photoExecute()
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
        return getRowCount33UseCase.photoExecute() == 0
    }
}