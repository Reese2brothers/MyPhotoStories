package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo52
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete52UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll52UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll52UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount52UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert52UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo52ViewModel @Inject constructor(
    private val insert52UseCase: Insert52UseCase,
    private val delete52UseCase: Delete52UseCase,
    private val getAll52UseCase: GetAll52UseCase,
    private val deleteAll52UseCase: DeleteAll52UseCase,
    private val getRowCount52UseCase: GetRowCount52UseCase
) : ViewModel() {


    private val _photos52 = MutableStateFlow<List<Photo52>>(emptyList())
    val photos52: StateFlow<List<Photo52>> = _photos52

    init {
        viewModelScope.launch {
            getAll52UseCase.photoExecute().collect { photoList ->
                _photos52.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo52: Photo52) {
        viewModelScope.launch(Dispatchers.IO) {
            insert52UseCase.photoExecute(photo52)
        }
    }
    fun deleteNewPhoto(photo52 : Photo52, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete52UseCase.photoExecute(photo52)
                _photos52.value = photos52.value.filterNot { it == photo52 }
                val uri = Uri.parse(photo52.image)
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
    fun deleteAll52Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll52UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll52UseCase.photoExecute()
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
        return getRowCount52UseCase.photoExecute() == 0
    }
}