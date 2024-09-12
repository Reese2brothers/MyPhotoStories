package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo40
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete40UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll40UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll40UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount40UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert40UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo40ViewModel @Inject constructor(
    private val insert40UseCase: Insert40UseCase,
    private val delete40UseCase: Delete40UseCase,
    private val getAll40UseCase: GetAll40UseCase,
    private val deleteAll40UseCase: DeleteAll40UseCase,
    private val getRowCount40UseCase: GetRowCount40UseCase
) : ViewModel() {


    private val _photos40 = MutableStateFlow<List<Photo40>>(emptyList())
    val photos40: StateFlow<List<Photo40>> = _photos40

    init {
        viewModelScope.launch {
            getAll40UseCase.photoExecute().collect { photoList ->
                _photos40.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo40: Photo40) {
        viewModelScope.launch(Dispatchers.IO) {
            insert40UseCase.photoExecute(photo40)
        }
    }
    fun deleteNewPhoto(photo40 : Photo40, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete40UseCase.photoExecute(photo40)
                _photos40.value = photos40.value.filterNot { it == photo40 }
                val uri = Uri.parse(photo40.image)
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

    fun deleteAll40Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll40UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll40UseCase.photoExecute()
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
        return getRowCount40UseCase.photoExecute() == 0
    }
}