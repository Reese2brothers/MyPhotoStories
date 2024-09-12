package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo53
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete53UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll53UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll53UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount53UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert53UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo53ViewModel @Inject constructor(
    private val insert53UseCase: Insert53UseCase,
    private val delete53UseCase: Delete53UseCase,
    private val getAll53UseCase: GetAll53UseCase,
    private val deleteAll53UseCase: DeleteAll53UseCase,
    private val getRowCount53UseCase: GetRowCount53UseCase
) : ViewModel() {


    private val _photos53 = MutableStateFlow<List<Photo53>>(emptyList())
    val photos53: StateFlow<List<Photo53>> = _photos53

    init {
        viewModelScope.launch {
            getAll53UseCase.photoExecute().collect { photoList ->
                _photos53.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo53: Photo53) {
        viewModelScope.launch(Dispatchers.IO) {
            insert53UseCase.photoExecute(photo53)
        }
    }
    fun deleteNewPhoto(photo53 : Photo53, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete53UseCase.photoExecute(photo53)
                _photos53.value = photos53.value.filterNot { it == photo53 }
                val uri = Uri.parse(photo53.image)
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
    fun deleteAll53Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll53UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll53UseCase.photoExecute()
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
        return getRowCount53UseCase.photoExecute() == 0
    }
}